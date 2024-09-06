package com.van.hexagonal.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.CoreMatchers.is;
import com.van.hexagonal.application.controller.rest.UserAccountRestController;
import com.van.hexagonal.application.dto.CreateUserAccountRequest;
import com.van.hexagonal.domain.exceptions.UserAccountAlreadyExistException;
import com.van.hexagonal.domain.model.Role;
import com.van.hexagonal.domain.model.UserAccount;
import com.van.hexagonal.domain.provider.IRoleProvider;
import com.van.hexagonal.domain.provider.IUserAccountProvider;
import com.van.hexagonal.domain.provider.IUserAccountSessionProvider;
import com.van.hexagonal.domain.service.IUserAccountService;
import com.van.hexagonal.domain.service.userAccount.UserAccountServiceImpl;
import com.van.hexagonal.infrastructure.database.entities.RoleEntity;
import com.van.hexagonal.infrastructure.database.entities.UserAccountEntity;
import com.van.hexagonal.infrastructure.database.repositories.DBRoleProviderAdapter;
import com.van.hexagonal.infrastructure.database.repositories.DBUserAccountProviderAdapter;
import com.van.hexagonal.infrastructure.database.repositories.DBUserAccountSessionProviderAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = UserAccountRestController.class)
//@Import({DBUserAccountProviderAdapter.class, DBRoleProviderAdapter.class, DBUserAccountSessionProviderAdapter.class})
public class UserAccountRestControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IUserAccountProvider userAccountProvider;

    @MockBean
    private IRoleProvider roleProvider;

    @MockBean
    private IUserAccountSessionProvider userAccountSessionProvider;

    @BeforeEach
    public void setUp() {
         when(roleProvider.get(2L)).thenReturn(Optional.of(Role.builder().id(2L).name("user").build()));
         when(userAccountProvider.save(any())).thenReturn(UserAccount.builder()
                 .id(4L)
                 .username("admins")
                 .password("test")
                 .language("en")
                 .role(Role.builder().id(2L).build()).build());

         when(userAccountProvider.save(UserAccount.builder()
                         .username("admin")
                         .password("test")
                         .language("fr")
                         .role(Role.builder().id(2L).build()).build()))
                 .thenReturn(UserAccount.builder()
                         .id(1L)
                         .username("admin")
                         .password("test")
                         .isEnable(true)
                         .logged(false)
                         .language("fr")
                         .role(Role.builder().id(2L).name("user").build())
                         .build());

        when(userAccountProvider.save(UserAccount.builder()

                .username("root")
                .password("test")
                .language("fr")
                .role(Role.builder().id(2L).build())
                .build()))
                .thenThrow(UserAccountAlreadyExistException.class);
    }

    @Test
//    @WithMockUser
    void onSave_whenValidInput_thenReturn200() throws Exception {
        //ACT
//        when(userAccountProvider.existByUsername("admin")).thenReturn(false);

        CreateUserAccountRequest userAccount= CreateUserAccountRequest.builder()
                .username("admin")
                .password("test")
                .language("fr")
                .roleId(2L)
                .build();

        RequestBuilder request = MockMvcRequestBuilders.post("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userAccount));

        //ASSERT
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        ;

    }

    @Test
   void  onSave_where_UserAlreadyExist() throws Exception{
        when(userAccountProvider.existByUsername("root")).thenReturn(true);
        CreateUserAccountRequest userAccount= CreateUserAccountRequest.builder()
               .username("root")
               .password("test")
               .language("fr")
               .roleId(2L)
               .build();

       RequestBuilder request = MockMvcRequestBuilders.post("/api/user")
               .contentType(MediaType.APPLICATION_JSON)
               .content(asJsonString(userAccount));

       //ASSERT
       mockMvc.perform(request)
               .andExpect(status().isInternalServerError())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.message",is("This user is already exist")))

       ;

   }

   @Test
    void  onSave_where_RoleNotFound() throws Exception{

        CreateUserAccountRequest userAccount= CreateUserAccountRequest.builder()
                .username("admins")
                .password("test")
                .language("fr")
                .roleId(1L)
                .build();

        RequestBuilder request = MockMvcRequestBuilders.post("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userAccount));

        //ASSERT
        mockMvc.perform(request)
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message",is("role not found with id 1")))

        ;

    }

    public String asJsonString(final Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }



}

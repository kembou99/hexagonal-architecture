package com.van.hexagonal.domain;

import com.van.hexagonal.domain.exceptions.RoleNotFoundException;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserAccountServiceTest {

    private final IUserAccountProvider userAccountProvider=new MockUserAccountProvider();
    private final IRoleProvider roleProvider=new MockRoleProvider();
    private final IUserAccountSessionProvider userAccountSessionProvider=new MockUserAccountSessionProvider();


    @Test
    public void createUserAccount_Test(){

        IUserAccountService userAccountService=new UserAccountServiceImpl(userAccountProvider,roleProvider,userAccountSessionProvider);
        UserAccount userAccount=UserAccount.builder()
                .id(3L)
                .username("root")
                .password("test")
               /* .logged(false)
                .isEnable(true)*/
                .language("fr")
                .role(Role.builder().id(2L).name("user").build())
                .build();
        UserAccount userAccountSaved=userAccountService.createUserAccount(userAccount);
        assertEquals(userAccount.getUsername(),userAccountSaved.getUsername() );
        assertTrue(userAccountSaved.isEnable());
        assertFalse(userAccountSaved.isLogged());
        assertNotNull(userAccountSaved.getPassword());
        assertNotNull(userAccount.getRole());

        UserAccount userAccount2=UserAccount.builder()
                .id(1L)
                .username("admin")
                .password("test")
                .logged(false)
                .isEnable(true)
                .language("fr")
                .role(Role.builder().id(2L).name("user").build())
                .build();
        assertThrows(UserAccountAlreadyExistException.class, () -> userAccountService.createUserAccount(userAccount2));

        UserAccount userAccount3=UserAccount.builder()
                .id(1L)
                .username("admin")
                .password("test")
                .logged(false)
                .isEnable(true)
                .language("fr")
                .role(Role.builder().id(4L).name("admin").build())
                .build();
        assertThrows(RoleNotFoundException.class, () -> userAccountService.createUserAccount(userAccount3));

    }

}

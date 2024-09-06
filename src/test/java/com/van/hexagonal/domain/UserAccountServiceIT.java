package com.van.hexagonal.domain;

import com.van.hexagonal.core.mappers.UserAccountMapper;
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
import com.van.hexagonal.infrastructure.database.repositories.DBRoleProviderAdapter;
import com.van.hexagonal.infrastructure.database.repositories.DBUserAccountProviderAdapter;
import com.van.hexagonal.infrastructure.database.repositories.DBUserAccountSessionProviderAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({DBUserAccountProviderAdapter.class, DBRoleProviderAdapter.class, DBUserAccountSessionProviderAdapter.class})
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Utilise la DB définie dans la configuration, ou H2 par défaut
public class UserAccountServiceIT {

    @Autowired
    private IUserAccountProvider userAccountProvider;

    @Autowired
    private IRoleProvider roleProvider;

    @Autowired
    private IUserAccountSessionProvider userAccountSessionProvider;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    public void setUp() {
        RoleEntity role=RoleEntity.builder()
                .name("user")
                .build();
        RoleEntity roleSaved=entityManager.persistAndFlush(role);
        UserAccountEntity userAccount=UserAccountEntity.builder()
                .username("admin")
                .role(RoleEntity.builder().id(roleSaved.getId()).build())
                .password("test")
                .language("fr")
                .build();
        entityManager.persist(userAccount);
    }

    @Test
    public void create_userAccount_IT(){

        IUserAccountService userAccountService=new UserAccountServiceImpl(userAccountProvider,roleProvider,userAccountSessionProvider);

        Role role=roleProvider.getAll().stream().findFirst().get();

        UserAccount userAccount=UserAccount.builder()
                .username("root")
                .password("test")
                .language("fr")
//                .logged(false)
//                .isEnable(true)
                .role(role)
                .build();
        UserAccount userAccountSaved=userAccountService.createUserAccount(userAccount);
        assertEquals(userAccount.getUsername(), userAccountSaved.getUsername());
        assertEquals(userAccount.getLanguage(), userAccountSaved.getLanguage());
        assertTrue(userAccountSaved.isEnable());
        assertFalse(userAccountSaved.isLogged());
        assertNotNull(userAccountSaved.getPassword());
        assertNotNull(userAccount.getRole());

        UserAccount userAccount2=UserAccount.builder()
                .username("admin")
                .password("test")
                .language("fr")
                .role(role)
                .build();
        assertThrows(UserAccountAlreadyExistException.class, () -> userAccountService.createUserAccount(userAccount2));

        UserAccount userAccount3=UserAccount.builder()
                .username("admin")
                .password("test")
                .language("fr")
                .role(Role.builder().id(100L).build())
                .build();

        assertThrows(RoleNotFoundException.class, () -> userAccountService.createUserAccount(userAccount3));

    }
}

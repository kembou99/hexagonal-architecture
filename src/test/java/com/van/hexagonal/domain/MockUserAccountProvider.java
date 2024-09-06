package com.van.hexagonal.domain;

import com.van.hexagonal.domain.model.Role;
import com.van.hexagonal.domain.model.UserAccount;
import com.van.hexagonal.domain.provider.IUserAccountProvider;

import java.util.*;

public class MockUserAccountProvider implements IUserAccountProvider {
    private final  List<UserAccount> userAccounts= new ArrayList<UserAccount>();

    public MockUserAccountProvider() {

        userAccounts.add(UserAccount.builder()
                .id(1L)
                .username("admin")
                .password("test")
                .logged(false)
                .isEnable(true)
                .language("fr")
                .role(Role.builder().id(2L).name("user").build())
                .build());
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        userAccounts.add(userAccount);
        return userAccounts.stream().filter(u->u.getUsername().equals(userAccount.getUsername())).findAny().orElse(null);
    }



    @Override
    public Optional<UserAccount> get(Long modelId) {
        return userAccounts.stream().filter(u-> Objects.equals(u.getId(), modelId)).findAny();
    }

    @Override
    public List<UserAccount> getAll() {
        return userAccounts;
    }

    @Override
    public List<UserAccount> search(UserAccount userAccount) {
        return null;
    }

    @Override
    public boolean existByUsername(String username) {

        return userAccounts.stream().anyMatch(s->s.getUsername().equals(username));
    }

    @Override
    public UserAccount findByUsername(String username) {
        return null;
    }
}

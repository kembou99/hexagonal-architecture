package com.van.hexagonal.domain;

import com.van.hexagonal.domain.model.Role;
import com.van.hexagonal.domain.provider.IRoleProvider;
import com.van.hexagonal.infrastructure.database.entities.RoleEntity;

import java.util.*;

public class MockRoleProvider implements IRoleProvider {

    private  List<Role> roles= new ArrayList<>();

    public MockRoleProvider() {
         roles.add(Role.builder()
                 .id(2L).name("user").build());
    }

    @Override
    public Role save(Role role) {
        return null;
    }


    @Override
    public Optional<Role> get(Long modelId) {
        return roles.stream().filter(r-> Objects.equals(r.getId(), modelId)).findAny();
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public List<Role> search(Role role) {
        return null;
    }
}

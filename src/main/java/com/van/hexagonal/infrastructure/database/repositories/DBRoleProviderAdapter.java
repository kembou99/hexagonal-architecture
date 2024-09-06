package com.van.hexagonal.infrastructure.database.repositories;

import com.van.hexagonal.core.mappers.RoleMapper;
import com.van.hexagonal.domain.model.Role;
import com.van.hexagonal.domain.provider.IRoleProvider;
import com.van.hexagonal.infrastructure.database.entities.RoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DBRoleProviderAdapter implements IRoleProvider {

    private final RoleEntityRepository roleEntityRepository;

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public Optional<Role> get(Long modelId) {
        Optional<RoleEntity> roleEntity=this.roleEntityRepository.findById(modelId);
        return roleEntity.stream().map(RoleMapper::entityToModelDomain).findAny();
    }

    @Override
    public List<Role> getAll() {
        return this.roleEntityRepository.findAll()
                .stream()
                .map(RoleMapper::entityToModelDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Role> search(Role role) {
        return null;
    }
}

package com.van.hexagonal.infrastructure.database.repositories;


import com.van.hexagonal.core.mappers.UserAccountMapper;
import com.van.hexagonal.domain.model.UserAccount;
import com.van.hexagonal.domain.provider.IUserAccountProvider;
import com.van.hexagonal.infrastructure.database.entities.RoleEntity;
import com.van.hexagonal.infrastructure.database.entities.UserAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DBUserAccountProviderAdapter implements IUserAccountProvider {

    private final UserAccountEntityRepository userAccountEntityRepository;

    private final RoleEntityRepository roleEntityRepository;

    @Autowired
    public DBUserAccountProviderAdapter(UserAccountEntityRepository userAccountEntityRepository, RoleEntityRepository roleEntityRepository) {
        this.userAccountEntityRepository = userAccountEntityRepository;

        this.roleEntityRepository = roleEntityRepository;
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        UserAccountEntity userAccountEntity= UserAccountMapper.ModelDomainToEntity(userAccount);
//        RoleEntity role=roleEntityRepository.findById(userAccountEntity.getRole().getId()).get();
//        userAccountEntity.setRole(role);
        UserAccountEntity userAccountSaved= userAccountEntityRepository.saveAndFlush(userAccountEntity);
        return UserAccountMapper.entityToModelDomain(userAccountSaved);
    }

    @Override
    public Optional<UserAccount> get(Long modelId) {
        return null;
    }

    @Override
    public List<UserAccount> getAll() {
        return this.userAccountEntityRepository.findAll()
                .stream().
                map(UserAccountMapper::entityToModelDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccount> search(UserAccount userAccount) {
        return null;
    }

    @Override
    public boolean existByUsername(String username) {
        return this.userAccountEntityRepository.existsByUsername(username);
    }

    @Override
    public UserAccount findByUsername(String username) {
        return UserAccountMapper.entityToModelDomain(this.userAccountEntityRepository.findByUsername(username));
    }
}

package com.van.hexagonal.domain.provider;

import com.van.hexagonal.core.BaseModelProvider;
import com.van.hexagonal.domain.model.Role;
import com.van.hexagonal.domain.model.UserAccount;
import com.van.hexagonal.infrastructure.database.entities.UserAccountEntity;

public interface IUserAccountProvider extends BaseModelProvider<UserAccount,Long> {
        boolean existByUsername(String username);
        UserAccount findByUsername(String username);
}

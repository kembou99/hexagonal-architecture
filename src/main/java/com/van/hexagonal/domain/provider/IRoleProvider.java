package com.van.hexagonal.domain.provider;

import com.van.hexagonal.core.BaseModelProvider;
import com.van.hexagonal.domain.model.Role;
import com.van.hexagonal.infrastructure.database.entities.RoleEntity;

import java.util.List;

public interface IRoleProvider extends BaseModelProvider<Role,Long> {

}

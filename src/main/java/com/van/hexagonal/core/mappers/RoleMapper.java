package com.van.hexagonal.core.mappers;

import com.van.hexagonal.application.dto.RoleResponse;
import com.van.hexagonal.domain.model.Role;
import com.van.hexagonal.domain.model.UserAccount;
import com.van.hexagonal.infrastructure.database.entities.RoleEntity;
import com.van.hexagonal.infrastructure.database.entities.UserAccountEntity;

public class RoleMapper {
  public   static RoleEntity ModelDomainToEntity(Role role) {
        return RoleEntity.builder().id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

   public static Role entityToModelDomain(RoleEntity role){
        return Role.builder().id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }
   public static RoleResponse modelDomainToDto(Role role){

        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }
}
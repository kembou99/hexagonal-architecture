package com.van.hexagonal.core.mappers;

import com.van.hexagonal.application.dto.CreateUserAccountRequest;
import com.van.hexagonal.application.dto.UserAccountResponse;
import com.van.hexagonal.domain.model.Role;
import com.van.hexagonal.domain.model.UserAccount;
import com.van.hexagonal.infrastructure.database.entities.UserAccountEntity;

public class UserAccountMapper {
  public static UserAccountEntity ModelDomainToEntity(UserAccount userAccount){
       return
      UserAccountEntity.builder()
              .id(userAccount.getId())
              .role(RoleMapper.ModelDomainToEntity(userAccount.getRole()))
              .username(userAccount.getUsername())
              .password(userAccount.getPassword())
              .isEnable(userAccount.isEnable())
              .language(userAccount.getLanguage())
              .logged(userAccount.isLogged())
              .build();
   }
  public static UserAccount entityToModelDomain(UserAccountEntity userAccountEntity){
       return UserAccount.builder().id(userAccountEntity.getId())
               .username(userAccountEntity.getUsername())
               .password(userAccountEntity.getPassword())
               .isEnable(userAccountEntity.isEnable())
               .logged(userAccountEntity.isLogged())
               .language(userAccountEntity.getLanguage())
               .role(RoleMapper.entityToModelDomain(userAccountEntity.getRole()))
               .build();

   }
   public static UserAccountResponse modelDomainToDto(UserAccount userAccount){
        return UserAccountResponse.builder()
                .id(userAccount.getId())
                .role(RoleMapper.modelDomainToDto(userAccount.getRole()))
                .username(userAccount.getUsername())
                .isEnable(userAccount.isEnable())
                .logged(userAccount.isLogged())
                .language(userAccount.getLanguage())
                .build();
   }
   public static UserAccount dtoCreateToModelDomain(CreateUserAccountRequest request){

      return UserAccount.builder()
              .username(request.getUsername())
              .password(request.getPassword())
              .language(request.getLanguage())
              .role(Role.builder().id(request.getRoleId()).build())
              .build();

   }

}

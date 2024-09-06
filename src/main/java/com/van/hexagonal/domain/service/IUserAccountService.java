package com.van.hexagonal.domain.service;

import com.van.hexagonal.domain.model.UserAccount;

import java.util.List;

public interface IUserAccountService {
      UserAccount createUserAccount(UserAccount userAccount);
      UserAccount activateUserAccount(Long userAccountId);
      UserAccount desactivateUserAccount(Long userAccountId);
      UserAccount updateUserAccount(UserAccount userAccount,Long userAccountId);
      void deleteUserAccount(Long userAccountId);
      List<UserAccount> search(UserAccount userAccount);
}

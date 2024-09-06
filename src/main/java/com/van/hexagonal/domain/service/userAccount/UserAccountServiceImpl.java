package com.van.hexagonal.domain.service.userAccount;

import com.van.hexagonal.domain.exceptions.RoleNotFoundException;
import com.van.hexagonal.domain.exceptions.UserAccountAlreadyExistException;
import com.van.hexagonal.domain.model.Role;
import com.van.hexagonal.domain.model.UserAccount;
import com.van.hexagonal.domain.provider.IRoleProvider;
import com.van.hexagonal.domain.provider.IUserAccountProvider;
import com.van.hexagonal.domain.provider.IUserAccountSessionProvider;
import com.van.hexagonal.domain.service.IUserAccountService;

import java.util.List;

public class UserAccountServiceImpl implements IUserAccountService {

    private final IUserAccountProvider userAccountProvider;

    private final IRoleProvider roleProvider;
    private final IUserAccountSessionProvider userAccountSessionProvider;

    public UserAccountServiceImpl(IUserAccountProvider userAccountProvider, IRoleProvider roleProvider, IUserAccountSessionProvider userAccountSessionProvider) {
        this.userAccountProvider = userAccountProvider;
        this.roleProvider = roleProvider;
        this.userAccountSessionProvider = userAccountSessionProvider;
    }

    @Override
    public UserAccount createUserAccount(UserAccount userAccount) {
         Role role=this.roleProvider.get(userAccount.getRole().getId()).orElseThrow(()->new RoleNotFoundException(userAccount.getRole().getId()));
         if(this.userAccountProvider.existByUsername(userAccount.getUsername()))
             throw new UserAccountAlreadyExistException();
         userAccount.setRole(role);
        return userAccountProvider.save(userAccount);
    }

    @Override
    public UserAccount activateUserAccount(Long userAccountId) {
        return null;
    }

    @Override
    public UserAccount desactivateUserAccount(Long userAccountId) {
        return null;
    }

    @Override
    public UserAccount updateUserAccount(UserAccount userAccount, Long userAccountId) {
        return null;
    }

    @Override
    public void deleteUserAccount(Long userAccountId) {

    }

    @Override
    public List<UserAccount> search(UserAccount userAccount) {
        return null;
    }
}

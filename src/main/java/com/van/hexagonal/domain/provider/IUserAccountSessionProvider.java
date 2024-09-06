package com.van.hexagonal.domain.provider;

import com.van.hexagonal.core.BaseModelProvider;
import com.van.hexagonal.domain.model.UserAccount;
import com.van.hexagonal.domain.model.UserAccountSession;

public interface IUserAccountSessionProvider extends BaseModelProvider<UserAccountSession,Long> {

}

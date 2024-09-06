package com.van.hexagonal.domain;

import com.van.hexagonal.domain.model.UserAccountSession;
import com.van.hexagonal.domain.provider.IUserAccountSessionProvider;

import java.util.List;
import java.util.Optional;

public class MockUserAccountSessionProvider implements IUserAccountSessionProvider {
    @Override
    public UserAccountSession save(UserAccountSession userAccountSession) {
        return null;
    }


    @Override
    public Optional<UserAccountSession> get(Long modelId) {
        return Optional.empty();
    }

    @Override
    public List<UserAccountSession> getAll() {
        return null;
    }

    @Override
    public List<UserAccountSession> search(UserAccountSession userAccountSession) {
        return null;
    }
}

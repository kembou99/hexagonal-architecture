package com.van.hexagonal.infrastructure.database.repositories;

import com.van.hexagonal.domain.model.UserAccountSession;
import com.van.hexagonal.domain.provider.IUserAccountSessionProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DBUserAccountSessionProviderAdapter implements IUserAccountSessionProvider {

    private final UserAccountEntityRepository userAccountEntityRepository;

    private final UserAccountSessionEntityRepository userAccountSessionEntityRepository;

    @Override
    public UserAccountSession save(UserAccountSession userAccountSession) {
        return null;
    }

    @Override
    public Optional<UserAccountSession> get(Long modelId) {
        return null;
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

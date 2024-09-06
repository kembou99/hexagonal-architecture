package com.van.hexagonal.infrastructure.database.repositories;

import com.van.hexagonal.infrastructure.database.entities.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAccountEntityRepository extends JpaRepository<UserAccountEntity, Long> {
    @Query("select u from UserAccountEntity u where u.username = ?1")
    UserAccountEntity findByUsername(String username);

    @Query("select (count(u) > 0) from UserAccountEntity u where u.username = ?1")
    boolean existsByUsername(String username);



}
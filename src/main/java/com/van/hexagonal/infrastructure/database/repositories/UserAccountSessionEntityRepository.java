package com.van.hexagonal.infrastructure.database.repositories;

import com.van.hexagonal.infrastructure.database.entities.UserAccountSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountSessionEntityRepository extends JpaRepository<UserAccountSessionEntity, Long> {
}
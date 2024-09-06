package com.van.hexagonal.infrastructure.database.repositories;

import com.van.hexagonal.infrastructure.database.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
}
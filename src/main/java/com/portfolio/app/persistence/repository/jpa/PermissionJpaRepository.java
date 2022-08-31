package com.portfolio.app.persistence.repository.jpa;

import com.portfolio.app.persistence.model.Permission;
import com.portfolio.app.persistence.repository.PermissionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionJpaRepository extends PermissionRepository, JpaRepository<Permission, Integer> {
}

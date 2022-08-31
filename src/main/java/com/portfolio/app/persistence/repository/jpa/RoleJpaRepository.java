package com.portfolio.app.persistence.repository.jpa;

import com.portfolio.app.persistence.model.Role;
import com.portfolio.app.persistence.repository.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends RoleRepository, JpaRepository<Role, Integer> {
}
package com.portfolio.app.persistence.repository.jpa;

import com.portfolio.app.persistence.model.Role;
import com.portfolio.app.persistence.repository.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleJpaRepository extends RoleRepository, JpaRepository<Role, Long> {
    @Override
    default List<Role> getAll() {
        return findAll();
    }
}

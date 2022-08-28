package com.portfolio.app.persistence.repository;

import com.portfolio.app.persistence.model.Role;

import java.util.List;

public interface RoleRepository {
    List<Role> getAll();
}

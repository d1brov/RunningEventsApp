package com.portfolio.app.persistence.repository;

import com.portfolio.app.persistence.model.Role;

public interface RoleRepository {
    Role findByName(String name);
}

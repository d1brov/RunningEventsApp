package com.portfolio.app.persistence.repository;

import com.portfolio.app.persistence.model.Permission;

import java.util.List;

public interface PermissionRepository {
    List<Permission> getAll();

    Permission getByName(String name);
}
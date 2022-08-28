package com.portfolio.app.persistence.repository;

import com.portfolio.app.persistence.model.UserCredentials;

import java.util.List;

public interface UserCredentialsRepository {
    List<UserCredentials> getAll();

    UserCredentials findByUsername(String username);
}

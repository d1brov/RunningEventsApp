package com.portfolio.app.persistence.repository;

import com.portfolio.app.persistence.model.UserCredentials;

public interface UserCredentialsRepository {
    UserCredentials findByUsername(String username);
}

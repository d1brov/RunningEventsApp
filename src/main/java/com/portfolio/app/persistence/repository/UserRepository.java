package com.portfolio.app.persistence.repository;

import com.portfolio.app.persistence.model.User;

public interface UserRepository {
    User save(User user);
}
package com.portfolio.app.persistence.repository;

import com.portfolio.app.persistence.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    User findByEmail(String email);
}

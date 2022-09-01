package com.portfolio.app.persistence.repository;

import com.portfolio.app.persistence.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    List<User> findAll();

    User findByEmail(String email);
}
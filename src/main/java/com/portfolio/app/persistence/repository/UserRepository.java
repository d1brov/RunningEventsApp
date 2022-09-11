package com.portfolio.app.persistence.repository;

import com.portfolio.app.persistence.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    List<User> findAll();

    User findByEmail(String email);

    Optional<User> findById(Integer id);
}
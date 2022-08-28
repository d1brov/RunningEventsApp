package com.portfolio.app.persistence.repository.jpa;

import com.portfolio.app.persistence.model.User;
import com.portfolio.app.persistence.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJpaRepository extends UserRepository, JpaRepository<User, Long> {
    @Override
    default List<User> getAll() {
        return findAll();
    }

    @Override
    User findByEmail(String email);
}

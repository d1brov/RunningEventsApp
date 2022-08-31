package com.portfolio.app.persistence.repository.jpa;

import com.portfolio.app.persistence.model.User;
import com.portfolio.app.persistence.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends UserRepository, JpaRepository<User, Integer> {
}

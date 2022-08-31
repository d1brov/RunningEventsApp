package com.portfolio.app.persistence.repository.jpa;

import com.portfolio.app.persistence.model.UserCredentials;
import com.portfolio.app.persistence.repository.UserCredentialsRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsJpaRepository extends UserCredentialsRepository, JpaRepository<UserCredentials, Integer> {
}
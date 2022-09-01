package com.portfolio.app.service;

import com.portfolio.app.persistence.model.User;
import com.portfolio.app.persistence.repository.UserRepository;
import com.portfolio.app.web.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User with email '%s' not found", email)));
    }
}
package com.portfolio.app.service;

import com.portfolio.app.persistence.model.User;
import com.portfolio.app.persistence.repository.UserRepository;
import com.portfolio.app.web.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new NotFoundException(
                        String.format("User with email '%s' not found", email)));
    }

    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("User with id '%s' not found", id)));
    }
}
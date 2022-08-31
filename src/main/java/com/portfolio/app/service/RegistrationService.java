package com.portfolio.app.service;

import com.portfolio.app.persistence.model.Role;
import com.portfolio.app.persistence.model.User;
import com.portfolio.app.persistence.model.UserCredentials;
import com.portfolio.app.persistence.repository.RoleRepository;
import com.portfolio.app.persistence.repository.UserCredentialsRepository;
import com.portfolio.app.persistence.repository.UserRepository;
import com.portfolio.app.security.access.RoleName;
import com.portfolio.app.web.dto.UserRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepository userRepository;
    private final UserCredentialsRepository userCredentialsRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(UserRegistrationDto userRegistrationDto) {
        String email = userRegistrationDto.getEmail();
        if (userCredentialsRepository.findByUsername(email) != null) {
            throw new NotYetImplementedException("IMPLEMENT ERROR THROW user already exists");
        }

        String encodedPassword = passwordEncoder.encode(userRegistrationDto.getPassword());

        Role userRole = roleRepository.findByName(RoleName.USER.name());

        UserCredentials credentials = new UserCredentials(
                email,
                encodedPassword,
                false,
                Set.of(userRole)
        );

        // todo maybe better set initialization with null checks
        User user = new User(
                null,
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                email,
                userRegistrationDto.getPhoneNumber(),
                userRegistrationDto.getEmergencyPhoneNumber(),
                credentials
        );

        return userRepository.save(user);
    }
}

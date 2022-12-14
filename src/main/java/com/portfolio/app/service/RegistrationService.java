package com.portfolio.app.service;

import com.portfolio.app.persistence.model.Role;
import com.portfolio.app.persistence.model.User;
import com.portfolio.app.persistence.model.UserCredentials;
import com.portfolio.app.persistence.repository.RoleRepository;
import com.portfolio.app.persistence.repository.UserCredentialsRepository;
import com.portfolio.app.persistence.repository.UserRepository;
import com.portfolio.app.security.access.RoleName;
import com.portfolio.app.web.dto.UserRegistrationDto;
import com.portfolio.app.web.exception.RegistrationParametersValidationException;
import com.portfolio.app.web.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepository userRepository;
    private final UserCredentialsRepository userCredentialsRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final Validator validator;

    public User register(UserRegistrationDto userRegistrationDto) {
        checkUserRegistrationDtoValidity(userRegistrationDto);
        String email = userRegistrationDto.getEmail();
        if (userCredentialsRepository.findByUsername(email) != null) {
            throw new UserAlreadyExistsException(
                    String.format("User with email '%s' already exists", email));
        }

        String encodedPassword = passwordEncoder.encode(userRegistrationDto.getPassword());
        Role userRole = roleRepository.findByName(RoleName.USER.name());
        UserCredentials credentials = new UserCredentials(
                email,
                encodedPassword,
                false,
                Set.of(userRole)
        );

        //todo maybe better set initialization with null checks
        User user = new User(
                null,
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getGender(),
                userRegistrationDto.getBirthDate(),
                email,
                userRegistrationDto.getPhoneNumber(),
                userRegistrationDto.getEmergencyPhoneNumber(),
                credentials,
                null
        );

        return userRepository.save(user);
    }

    private void checkUserRegistrationDtoValidity(UserRegistrationDto userRegistrationDto) {
        Set<ConstraintViolation<UserRegistrationDto>> violations = validator.validate(userRegistrationDto);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserRegistrationDto> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
                sb.append("\n");
            }
            throw new RegistrationParametersValidationException(sb.toString());
        }
    }
}
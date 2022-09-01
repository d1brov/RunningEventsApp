package com.portfolio.app.web.dto;

import com.portfolio.app.persistence.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegistrationDto {
    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private Gender gender;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be valid")
    private String email;

    private String phoneNumber;

    private String emergencyPhoneNumber;

    @NotEmpty(message = "Password must not be empty")
    @Size(min = 8, max = 64, message = "Password must be 8 - 64 characters length")
    private String password;
}
package com.portfolio.app.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegistrationDto {
    private String firstName;

    private String lastName;

    @NotEmpty
    @Email
    private String email;

    private String phoneNumber;

    private String emergencyPhoneNumber;

    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;
}

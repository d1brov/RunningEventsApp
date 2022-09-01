package com.portfolio.app.web.dto;

import com.portfolio.app.persistence.model.Gender;
import com.portfolio.app.persistence.model.UserCredentials;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String email;
    private String phoneNumber;
    private String emergencyPhoneNumber;
    private UserCredentials credentials;
}

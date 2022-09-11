package com.portfolio.app.web.controller;

import com.portfolio.app.persistence.model.User;
import com.portfolio.app.service.RegistrationService;
import com.portfolio.app.web.dto.UserDto;
import com.portfolio.app.web.dto.UserRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(CREATED)
    UserDto register(@RequestBody UserRegistrationDto userRegistrationDto) {
        User registeredUser = registrationService.register(userRegistrationDto);
        return modelMapper.map(registeredUser, UserDto.class);
    }
}
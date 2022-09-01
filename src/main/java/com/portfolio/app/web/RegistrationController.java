package com.portfolio.app.web;

import com.portfolio.app.persistence.model.User;
import com.portfolio.app.service.RegistrationService;
import com.portfolio.app.web.dto.EntityToDtoConverter;
import com.portfolio.app.web.dto.UserDto;
import com.portfolio.app.web.dto.UserRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    private final EntityToDtoConverter entityConverter;

    @PostMapping
    @ResponseStatus(CREATED)
    UserDto register(@RequestBody UserRegistrationDto userRegistrationDto) {
        User registeredUser = registrationService.register(userRegistrationDto);
        return entityConverter.toDto(registeredUser);
    }
}
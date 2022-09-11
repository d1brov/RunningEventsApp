package com.portfolio.app.web.controller;

import com.portfolio.app.persistence.model.User;
import com.portfolio.app.service.UserService;
import com.portfolio.app.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UsersController {
    private final UserService usersService;
    private final ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(OK)
    List<UserDto> getAllUsers() {
        return usersService.getAllUsers().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("byEmail/{email}")
    @ResponseStatus(OK)
    UserDto getUserByEmail(@PathVariable String email) {
        User foundUser = usersService.getByEmail(email);
        return modelMapper.map(foundUser, UserDto.class);
    }

    @GetMapping("byId/{id}")
    @ResponseStatus(OK)
    UserDto getUserById(@PathVariable Integer id) {
        User foundUser = usersService.getById(id);
        return modelMapper.map(foundUser, UserDto.class);
    }
}

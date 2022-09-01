package com.portfolio.app.web;

import com.portfolio.app.service.UsersService;
import com.portfolio.app.web.dto.EntityToDtoConverter;
import com.portfolio.app.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    private final EntityToDtoConverter entityConverter;

    @GetMapping
    @ResponseStatus(OK)
    List<UserDto> getAllUsers() {
        return entityConverter.toDtos(usersService.getAllUsers());
    }

    @GetMapping("/{email}")
    @ResponseStatus(OK)
    UserDto getUserByEmail(@PathVariable String email) {
        return entityConverter.toDto(usersService.getByEmail(email));
    }
}

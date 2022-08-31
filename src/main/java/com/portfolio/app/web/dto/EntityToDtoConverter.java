package com.portfolio.app.web.dto;

import com.portfolio.app.persistence.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EntityToDtoConverter {
    private final ModelMapper modelMapper;

    public UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> toDtos(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>(users.size());
        users.forEach(user -> userDtos.add(toDto(user)));
        return userDtos;
    }
}
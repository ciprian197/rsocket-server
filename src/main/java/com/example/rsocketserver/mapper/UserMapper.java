package com.example.rsocketserver.mapper;

import com.example.rsocketserver.dto.UserCreationDto;
import com.example.rsocketserver.dto.UserDto;
import com.example.rsocketserver.model.User;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(@NonNull final UserCreationDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName()).build();
    }

    public UserDto toDto(@NonNull final User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName()).build();
    }

}

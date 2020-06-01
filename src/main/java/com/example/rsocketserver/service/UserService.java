package com.example.rsocketserver.service;

import com.example.rsocketserver.dto.UserCreationDto;
import com.example.rsocketserver.dto.UserDto;
import com.example.rsocketserver.mapper.UserMapper;
import com.example.rsocketserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Mono<UserDto> createUser(final UserCreationDto creationDto) {
        return Mono.just(creationDto)
                .map(userMapper::toEntity)
                .flatMap(userRepository::save)
                .map(userMapper::toDto);
    }

}

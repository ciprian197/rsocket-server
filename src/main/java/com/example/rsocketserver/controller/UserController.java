package com.example.rsocketserver.controller;

import com.example.rsocketserver.dto.UserCreationDto;
import com.example.rsocketserver.dto.UserDto;
import com.example.rsocketserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @MessageMapping("createUser")
    public Mono<UserDto> createUser(@Valid final UserCreationDto creationDto) {
        return userService.createUser(creationDto);
    }

}

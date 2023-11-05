package com.reto.bancom.presentation.controller;

import com.reto.bancom.application.dto.UserDto;
import com.reto.bancom.application.dto.UserRequestDto;
import com.reto.bancom.application.dto.UserResponseDto;
import com.reto.bancom.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/external/user")
@RequiredArgsConstructor
public class PublicController {

    private final UserService userService;

    @PostMapping("/user-create")
    public UserDto createUser(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @GetMapping("/user-list")
    public List<UserResponseDto> users() {
        return userService.users();
    }
}

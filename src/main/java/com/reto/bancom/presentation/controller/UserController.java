package com.reto.bancom.presentation.controller;

import com.reto.bancom.application.dto.UserDto;
import com.reto.bancom.application.dto.UserRequestDto;
import com.reto.bancom.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/user-update")
    public UserDto updateUser(@RequestBody UserRequestDto requestDto) {
        return userService.updateUser(requestDto);
    }


    @DeleteMapping("/user-delete/{userId}")
    public boolean deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}

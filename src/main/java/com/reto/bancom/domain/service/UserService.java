package com.reto.bancom.domain.service;

import com.reto.bancom.application.dto.UserDto;
import com.reto.bancom.application.dto.UserRequestDto;
import com.reto.bancom.application.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserRequestDto requestDto);

    UserDto updateUser(UserRequestDto requestDto);

    List<UserResponseDto> users();

    boolean deleteUser(Long userId);
}

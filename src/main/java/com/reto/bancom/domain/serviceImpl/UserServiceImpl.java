package com.reto.bancom.domain.serviceImpl;

import com.reto.bancom.application.dto.UserDto;
import com.reto.bancom.application.dto.UserRequestDto;
import com.reto.bancom.application.dto.UserResponseDto;
import com.reto.bancom.application.mapper.UserMapper;
import com.reto.bancom.domain.service.UserService;
import com.reto.bancom.infrastructure.persistence.entity.UserEntity;
import com.reto.bancom.infrastructure.persistence.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDto createUser(UserRequestDto requestDto) {
        Optional<UserEntity> entity = userRepository.findByName(requestDto.getName());
        if (entity.isPresent()) {
            throw new RuntimeException("Ya existe un usuario con este nombre");
        }

        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        UserEntity user = userRepository.save(UserMapper.INSTANCE.mapUser(requestDto));

        return UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getName())
                .build();
    }

    @Override
    @Transactional
    public UserDto updateUser(UserRequestDto requestDto) {
        userRepository.findById(requestDto.getId()).orElseThrow(() -> new RuntimeException("Usuario no existe"));

        UserEntity user = userRepository.save(UserMapper.INSTANCE.mapUser(requestDto));
        return UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getName())
                .build();
    }

    @Override
    public List<UserResponseDto> users() {
        List<UserEntity> list = userRepository.findAll();
        return list.stream().map(UserMapper.INSTANCE::map).collect(Collectors.toList());
    }

    @Override
    public boolean deleteUser(Long userId) {
        try {
            userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no existe"));

            userRepository.deleteById(userId);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo eliminar usuario");
        }
    }
}

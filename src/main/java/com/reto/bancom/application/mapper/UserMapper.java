package com.reto.bancom.application.mapper;

import com.reto.bancom.application.dto.UserRequestDto;
import com.reto.bancom.application.dto.UserResponseDto;
import com.reto.bancom.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    default UserEntity mapUser(UserRequestDto requestDto) {
        UserEntity entity = new UserEntity();
        entity.setUserId(requestDto.getId());
        entity.setName(requestDto.getName());
        entity.setLastName(requestDto.getLastName());
        entity.setCellPhone(requestDto.getCellPhone());
        entity.setPassword(requestDto.getPassword());
        return entity;
    }

    default UserResponseDto map(UserEntity entity) {
        return UserResponseDto.builder()
                .id(entity.getUserId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .cellPhone(entity.getCellPhone())
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getUpdatedDate())
                .build();
    }
}

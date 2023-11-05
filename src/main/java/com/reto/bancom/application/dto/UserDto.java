package com.reto.bancom.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long userId;
    private String userName;
}

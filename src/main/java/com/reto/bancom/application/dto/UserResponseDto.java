package com.reto.bancom.application.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String cellPhone;
    private String name;
    private String lastName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

package com.reto.bancom.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private Long id;
    private String cellPhone;
    private String name;
    private String lastName;
    private String password;
}

package com.reto.bancom.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Data
@Builder
public class PostUserDto {
    private Long postId;
    private String textPost;
}

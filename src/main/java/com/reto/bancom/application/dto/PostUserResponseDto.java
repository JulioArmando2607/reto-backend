package com.reto.bancom.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Builder
public class PostUserResponseDto {
    private Long postId;
    private String textPost;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
 }

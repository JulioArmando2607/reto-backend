package com.reto.bancom.domain.service;

import com.reto.bancom.application.dto.PostUserDto;
import com.reto.bancom.application.dto.PostUserRequesDto;
import com.reto.bancom.application.dto.PostUserResponseDto;

import java.util.List;

public interface PostUserService {

    PostUserDto createPost(PostUserRequesDto postUserRequesDto);
    PostUserDto updatePost(PostUserRequesDto postUserRequesDto);
    List<PostUserResponseDto> posts(Long userId);
    boolean deletePost(Long postId);
}

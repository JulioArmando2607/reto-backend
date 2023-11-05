package com.reto.bancom.presentation.controller;

import com.reto.bancom.application.dto.PostUserDto;
import com.reto.bancom.application.dto.PostUserRequesDto;
import com.reto.bancom.application.dto.PostUserResponseDto;
import com.reto.bancom.domain.service.PostUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostUserController {

    private final PostUserService postUserService;

    @PostMapping("/post-create")
    public PostUserDto createPost(@RequestBody PostUserRequesDto postUserRequesDto) {
        return postUserService.createPost(postUserRequesDto);
    }

    @PutMapping("/post-update")
    public PostUserDto updatePost(@RequestBody PostUserRequesDto postUserRequesDto) {
        return postUserService.updatePost(postUserRequesDto);
    }

    @GetMapping("/post-list/{userId}")
    public List<PostUserResponseDto> postList(@PathVariable Long userId) {
        return postUserService.posts(userId);
    }

    @DeleteMapping("/post-delete/{idPost}")
    public boolean deletePost(@PathVariable Long idPost) {
        return postUserService.deletePost(idPost);
    }
}

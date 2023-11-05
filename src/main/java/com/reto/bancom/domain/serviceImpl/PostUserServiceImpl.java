package com.reto.bancom.domain.serviceImpl;

import com.reto.bancom.application.dto.PostUserDto;
import com.reto.bancom.application.dto.PostUserRequesDto;
import com.reto.bancom.application.dto.PostUserResponseDto;
import com.reto.bancom.application.mapper.PostMapper;
import com.reto.bancom.application.security.UtilsSecurity;
import com.reto.bancom.domain.service.PostUserService;
import com.reto.bancom.infrastructure.persistence.entity.PostEntity;
import com.reto.bancom.infrastructure.persistence.repository.PostUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostUserServiceImpl implements PostUserService {

    private final PostUserRepository postUserRepository;


    @Override
    @Transactional
    public PostUserDto createPost(PostUserRequesDto postUserRequesDto) {
        PostEntity postEntity = postUserRepository.save(PostMapper.INSTANCE.mapPost(postUserRequesDto));
        return PostUserDto.builder()
                .postId(postEntity.getPostId())
                .textPost(postEntity.getText())
                .build();
    }

    @Override
    @Transactional
    public PostUserDto updatePost(PostUserRequesDto postUserDto) {
        PostEntity entity = postUserRepository.findById(postUserDto.getPostId()).orElseThrow(() -> new RuntimeException("Post no existe"));
        if (!Objects.equals(UtilsSecurity.getUserId(), entity.getUserId())) {
            throw new RuntimeException("No puede editar este post");
        }

        PostEntity postEntity = postUserRepository.save(PostMapper.INSTANCE.mapPost(postUserDto));

        return PostUserDto.builder()
                .postId(postEntity.getPostId())
                .textPost(postEntity.getText())
                .build();
    }

    @Override
    public List<PostUserResponseDto> posts(Long userId) {
        List<PostEntity> list = postUserRepository.findByUserId(userId);
        for (PostEntity postEntity : list) {
            log.info(postEntity.getCreatedDate().toString());
        }
        return list.stream().map(PostMapper.INSTANCE::map).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean deletePost(Long postId) {

        PostEntity entity = postUserRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post no existe"));

        if (!Objects.equals(UtilsSecurity.getUserId(), entity.getUserId())) {
            throw new RuntimeException("No puede eliminar este post");
        }

        try {
            postUserRepository.deleteById(postId);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo eliminar post");
        }
    }
}

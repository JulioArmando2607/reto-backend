package com.reto.bancom.application.mapper;

import com.reto.bancom.application.dto.PostUserDto;
import com.reto.bancom.application.dto.PostUserRequesDto;
import com.reto.bancom.application.dto.PostUserResponseDto;
import com.reto.bancom.infrastructure.persistence.entity.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    default PostEntity mapPost(PostUserRequesDto postUserDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostId(postUserDto.getPostId());
        postEntity.setText(postUserDto.getTextPost());
        return postEntity;
    }

    default PostUserResponseDto map(PostEntity postEntity) {
        return PostUserResponseDto.builder()
                .postId(postEntity.getPostId())
                .textPost(postEntity.getText())
                //.user(postEntity.getUserId())
                .createdDate(postEntity.getCreatedDate())
                .updatedDate(postEntity.getUpdatedDate())
                .build();
    }
}

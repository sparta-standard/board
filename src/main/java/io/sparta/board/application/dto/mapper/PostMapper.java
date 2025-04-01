package io.sparta.board.application.dto.mapper;

import io.sparta.board.application.dto.response.PostCreateResponseDto;
import io.sparta.board.domain.entity.Post;

public class PostMapper {

    public static PostCreateResponseDto toPostCreateResponseDto(Post post) {
        return PostCreateResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}

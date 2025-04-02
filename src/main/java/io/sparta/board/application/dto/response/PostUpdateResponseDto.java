package io.sparta.board.application.dto.response;

import io.sparta.board.domain.model.Post;
import lombok.Builder;

import java.util.Date;

@Builder
public record PostUpdateResponseDto(
        Long id,
        String title,
        String content,
        Date updatedAt
) {

    public static PostUpdateResponseDto from(Post post) {
        return PostUpdateResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}

package io.sparta.board.application.dto.response;

import io.sparta.board.domain.model.Post;
import lombok.Builder;
import org.springframework.data.domain.Page;

import java.util.Date;

@Builder
public record PostResponseDto(
        Long id,
        String title,
        String content,
        Date createdAt,
        Date updatedAt,
        Page<CommentResponseDto> comments
) {
    public static PostResponseDto from(Post post, Page<CommentResponseDto> commentPage) {
        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .comments(commentPage)
                .build();
    }
}

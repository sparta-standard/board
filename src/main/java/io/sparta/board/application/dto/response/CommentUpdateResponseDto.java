package io.sparta.board.application.dto.response;

import io.sparta.board.domain.model.Comment;
import lombok.Builder;

import java.util.Date;

@Builder
public record CommentUpdateResponseDto(
        Long id,
        String content,
        Long postId,
        Date updatedAt
) {

    public static CommentUpdateResponseDto from(Comment comment) {
        return CommentUpdateResponseDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .postId(comment.getPost().getId())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}

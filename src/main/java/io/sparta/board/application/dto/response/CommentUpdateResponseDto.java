package io.sparta.board.application.dto.response;

import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class CommentUpdateResponseDto {
    private UUID id;
    private String content;
    private UUID postId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommentUpdateResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.postId = comment.getPost().getId();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }

}

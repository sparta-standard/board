package io.sparta.board.application.dto.response;

import io.sparta.board.domain.model.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class DeleteCommentResponseDto {
    private UUID id;
    private String comment;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID postId;

    public DeleteCommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getContent();
        this.deleted = comment.isDeleted();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
        this.postId = comment.getPost().getId();
    }
}

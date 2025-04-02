package io.sparta.board.application.dto.response;

import io.sparta.board.domain.model.Comment;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class CommentCreateResponseDto {
    private UUID id;
    private UUID postId;
    private String content;
    private LocalDateTime createdAt;

    public CommentCreateResponseDto(Comment comment) {
        this.id = comment.getId();
        this.postId = comment.getPost().getId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
    }

}

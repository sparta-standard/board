package io.sparta.board.comment.dto;

import io.sparta.board.comment.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {

    private UUID id;
    private UUID postId;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.postId = comment.getPost().getId();
        this.content = comment.getContent();
    }
}

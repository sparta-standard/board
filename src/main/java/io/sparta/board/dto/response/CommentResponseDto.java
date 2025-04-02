package io.sparta.board.dto.response;

import io.sparta.board.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private UUID id;
    private UUID postId;
    private String content;
    private LocalDateTime createdAt;

    public CommentResponseDto(Comment comment) {

        this.id = comment.getId();
        this.postId = comment.getPost().getId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();

    }
}

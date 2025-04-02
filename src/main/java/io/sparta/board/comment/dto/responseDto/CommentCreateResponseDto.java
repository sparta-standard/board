package io.sparta.board.comment.dto.responseDto;

import io.sparta.board.comment.model.Comment;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentCreateResponseDto {

    private UUID id;
    private UUID postId;
    private String comment;
    private LocalDateTime createdAt;

    public CommentCreateResponseDto(Comment comment) {
        this.id = comment.getId();
        this.postId = comment.getPost().getId();
        this.comment = comment.getContent();
        this.createdAt = comment.getCreatedAt();
    }

}

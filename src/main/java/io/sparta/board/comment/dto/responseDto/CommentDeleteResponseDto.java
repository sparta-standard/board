package io.sparta.board.comment.dto.responseDto;

import java.util.UUID;
import lombok.Getter;

@Getter
public class CommentDeleteResponseDto {

    private final UUID commnetId;
    private String message;

    public CommentDeleteResponseDto(UUID commentId,  String message) {
        this.commnetId = commentId;
        this.message = message;
    }

}

package io.sparta.board.comment.application.dto.response;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentCreateResponseDto {

    private UUID postId;
    private UUID commentId;
    private String content;
}

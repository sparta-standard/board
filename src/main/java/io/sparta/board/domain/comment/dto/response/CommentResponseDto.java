package io.sparta.board.domain.comment.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class CommentResponseDto {

    private UUID id;
    private UUID postId;
    private String content;
}

package io.sparta.board.domain.comment.dto.requeset;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentUpdateRequestDto {
    private String content;
}

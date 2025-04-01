package io.sparta.board.application.dto.comment;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentRequestInternalDto {

    private String content;
}

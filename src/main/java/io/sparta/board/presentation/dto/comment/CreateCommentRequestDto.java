package io.sparta.board.presentation.dto.comment;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateCommentRequestDto {

    private UUID postId;
    private String content;
}

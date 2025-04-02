package io.sparta.board.controller.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UpdateCommentRequestDto {
    public UUID id;
    public String content;
}

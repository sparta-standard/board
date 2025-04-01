package io.sparta.board.board.presentation.controller;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardUpdateResponseDto {

    private UUID boardId;
    private String title;
    private String content;
}

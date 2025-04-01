package io.sparta.board.board.application.dto.response;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardSearchResponseDto {

    private UUID boardId;
    private String title;
    private String content;
}

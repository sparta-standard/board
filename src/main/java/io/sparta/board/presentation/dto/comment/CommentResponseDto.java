package io.sparta.board.presentation.dto.comment;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class CommentResponseDto {

    private UUID id;
    private LocalDateTime createdAt;
    private String content;
}

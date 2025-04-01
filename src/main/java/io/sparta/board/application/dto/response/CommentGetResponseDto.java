package io.sparta.board.application.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentGetResponseDto(

        String content,
        LocalDateTime createdAt
) {
}

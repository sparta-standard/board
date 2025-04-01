package io.sparta.board.application.dto.response;

import java.time.LocalDateTime;

public record CommentGetResponseDto(

        String content,
        LocalDateTime createdAt
) {
}

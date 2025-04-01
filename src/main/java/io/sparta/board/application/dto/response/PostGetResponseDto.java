package io.sparta.board.application.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record PostGetResponseDto(

        String title,
        String content,
        LocalDateTime createdAt,
        List<CommentGetResponseDto> comments
) {
}

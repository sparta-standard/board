package io.sparta.board.application.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record PostGetResponseDto(

        String title,
        String content,
        LocalDateTime createdAt,
        List<CommentGetResponseDto> comments
) {
}

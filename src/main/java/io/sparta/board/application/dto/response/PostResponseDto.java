package io.sparta.board.application.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record PostResponseDto(

        UUID id,
        String title,
        LocalDateTime createdAt

) {
}

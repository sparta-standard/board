package io.sparta.board.domain.post.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class PostResponseDto {
    private UUID id;
    private String title;
}

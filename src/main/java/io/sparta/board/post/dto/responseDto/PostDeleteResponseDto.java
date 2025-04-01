package io.sparta.board.post.dto.responseDto;

import java.util.UUID;
import lombok.Getter;

@Getter
public class PostDeleteResponseDto {

    private final UUID id;
    private final String message;

    public PostDeleteResponseDto(UUID id, String message) {
        this.id = id;
        this.message = message;
    }

}

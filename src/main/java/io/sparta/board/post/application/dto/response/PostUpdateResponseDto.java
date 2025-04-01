package io.sparta.board.post.application.dto.response;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostUpdateResponseDto {

    private UUID postId;
    private String title;
    private String content;
}

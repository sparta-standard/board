package io.sparta.board.presentation.dto.response;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePostResponseDto {

    private UUID postId;
    private String title;
    private String content;


}

package io.sparta.board.application.dto.post;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePostInternalDto {

    private String title;
    private String content;
}

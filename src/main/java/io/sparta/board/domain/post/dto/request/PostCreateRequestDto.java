package io.sparta.board.domain.post.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostCreateRequestDto {

    private String title;
    private String content;
}

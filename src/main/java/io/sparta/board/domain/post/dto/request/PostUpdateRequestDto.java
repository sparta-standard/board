package io.sparta.board.domain.post.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostUpdateRequestDto {

    private String title;
    private String content;
}
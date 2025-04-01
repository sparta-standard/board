package io.sparta.board.post.application.dto.request;

import lombok.Getter;

@Getter
public class PostCreateRequestDto {

    private String title;
    private String content;
}

package io.sparta.board.application.dto.request;

import io.sparta.board.domain.model.Post;

public record PostRequestDto(
        String title,
        String content
) {

    public Post createPost() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
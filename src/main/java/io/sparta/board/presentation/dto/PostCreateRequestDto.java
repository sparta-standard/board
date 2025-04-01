package io.sparta.board.presentation.dto;

import io.sparta.board.model.entity.Post;
import lombok.Builder;

@Builder
public class PostCreateRequestDto {
    private final String title;
    private final String content;

    public Post createPost() {
        return Post.createPost(title, content);
    }
}

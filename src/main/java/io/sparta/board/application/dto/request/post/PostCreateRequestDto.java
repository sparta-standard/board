package io.sparta.board.application.dto.request.post;

import io.sparta.board.domain.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateRequestDto {
    private String title;
    private String content;

    public Post toEntity() {
        return Post.create(
                title,
                content
        );
    }

}

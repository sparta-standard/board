package io.sparta.board.post.dto.responseDto;

import io.sparta.board.post.model.Post;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostCreateResponseDto {

    private final UUID id;
    private final String title;
    private final String content;
    private final Long count;
    private final LocalDateTime createdAt;

    public PostCreateResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.count = post.getCount();
        this.createdAt = post.getCreatedAt();
    }

}

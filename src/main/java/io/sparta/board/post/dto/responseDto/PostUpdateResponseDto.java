package io.sparta.board.post.dto.responseDto;

import io.sparta.board.post.model.Post;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostUpdateResponseDto {

    private final UUID post_id;
    private final String title;
    private final String content;
    private final Long count;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public PostUpdateResponseDto(Post post) {
        this.post_id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.count = post.getCount();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
    }

}

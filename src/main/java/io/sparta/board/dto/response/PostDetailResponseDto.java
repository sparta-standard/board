package io.sparta.board.dto.response;

import io.sparta.board.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class PostDetailResponseDto {
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostDetailResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
    }
}

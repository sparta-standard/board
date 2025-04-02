package io.sparta.board.dto;

import io.sparta.board.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime createdAt;


    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();

    }
}
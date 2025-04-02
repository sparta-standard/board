package io.sparta.board.application.dto.response;

import io.sparta.board.domain.model.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PostCreationResponseDto {
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public PostCreationResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = LocalDateTime.now();
    }
}

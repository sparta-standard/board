package io.sparta.board.post.dto.responseDto;

import io.sparta.board.comment.dto.responseDto.CommentResponseDto;
import io.sparta.board.post.model.Post;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@AllArgsConstructor
public class PostDetailsResponseDto {

    private final UUID id;
    private final String title;
    private final String content;
    private final Long count;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final Page<CommentResponseDto> comments;

    public PostDetailsResponseDto(Post post, Page<CommentResponseDto> comments) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.count = post.getCount();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.comments = comments;
    }

}

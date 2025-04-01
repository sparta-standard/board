package io.sparta.board.post.dto;

import io.sparta.board.comment.dto.CommentResponseDto;
import io.sparta.board.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {

    private UUID id;
    private String title;
    private String content;
    private Page<CommentResponseDto> comments;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }

    public PostResponseDto(Post post, Page<CommentResponseDto> comments) {
        this(post);
        this.comments = comments;
    }
}

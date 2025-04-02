package io.sparta.board.dto.post;

import io.sparta.board.dto.comment.CommentResponseDto;
import io.sparta.board.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class PostDetailResponseDto {
    private final UUID id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private List<CommentResponseDto> comments;

    @Builder
    public PostDetailResponseDto(UUID id, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt, List<CommentResponseDto> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.comments = comments;
    }

    public static PostDetailResponseDto from(Post post, List<CommentResponseDto> comments) {
        return PostDetailResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .comments(comments)
                .build();
    }
}

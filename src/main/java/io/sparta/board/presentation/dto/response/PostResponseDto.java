package io.sparta.board.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sparta.board.model.entity.Post;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public class PostResponseDto {

    @JsonProperty
    private final UUID id;
    @JsonProperty
    private final String title;
    @JsonProperty
    private final String content;
    @JsonProperty
    private final List<CommentResponseDto> comments;

    public static PostResponseDto toResponseDto(Post post, List<CommentResponseDto> comments) {
        return PostResponseDto.builder()
            .id(post.getId())
            .title(post.getTitle())
            .content(post.getContent())
            .comments(comments)
            .build();
    }

    public static PostResponseDto toResponseDto(Post post) {
        return PostResponseDto.builder()
            .id(post.getId())
            .title(post.getTitle())
            .content(post.getContent())
            .build();
    }
}

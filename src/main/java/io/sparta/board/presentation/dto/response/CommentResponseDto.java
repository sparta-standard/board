package io.sparta.board.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sparta.board.model.entity.Comment;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public class CommentResponseDto {

    @JsonProperty
    private final UUID id;
    @JsonProperty
    private final UUID postId;
    @JsonProperty
    private final String content;

    public static CommentResponseDto toResponseDto(Comment comment) {
        return CommentResponseDto.builder()
            .id(comment.getId())
            .postId(comment.getPost().getId())
            .content(comment.getContent())
            .build();
    }
}

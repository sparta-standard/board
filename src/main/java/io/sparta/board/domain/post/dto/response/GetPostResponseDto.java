package io.sparta.board.domain.post.dto.response;

import io.sparta.board.model.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class GetPostResponseDto {
    private UUID id;
    private String title;
    private String content;
    private List<String> comments;
}

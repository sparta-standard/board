package io.sparta.board.presentation.dto.response;

import io.sparta.board.presentation.dto.CommentDto;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetPostResponseDto {
    private UUID postId;
    private String title;
    private String content;
    private List<CommentDto> comments;
}

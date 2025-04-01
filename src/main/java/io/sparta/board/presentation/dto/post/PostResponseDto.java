package io.sparta.board.presentation.dto.post;

import io.sparta.board.presentation.dto.comment.CommentResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class PostResponseDto {

    private UUID id;
    private LocalDateTime createAt;
    private String title;
    private String content;
    private List<CommentResponseDto> comments;
}

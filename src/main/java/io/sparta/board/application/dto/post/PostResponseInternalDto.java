package io.sparta.board.application.dto.post;

import io.sparta.board.application.dto.comment.CommentResponseInternalDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class PostResponseInternalDto {

    private UUID id;
    private LocalDateTime createAt;
    private String title;
    private String content;
    private List<CommentResponseInternalDto> comments;
}

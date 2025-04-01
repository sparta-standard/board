package io.sparta.board.application.dto.comment;

import io.sparta.board.application.dto.post.PostResponseInternalDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class CommentResponseInternalDto {

    private UUID id;
    private LocalDateTime createdAt;
    private String content;
}

package io.sparta.board.application.dto.response;

import io.sparta.board.domain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostGetResponseDto {
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<CommentResponseDto> commentList;
}

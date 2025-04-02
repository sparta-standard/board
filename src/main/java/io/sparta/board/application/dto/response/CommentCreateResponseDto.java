package io.sparta.board.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;

@Getter
public class CommentCreateResponseDto {

  private UUID id;
  private UUID postId;
  private String content;
  private LocalDateTime createdAt;
}

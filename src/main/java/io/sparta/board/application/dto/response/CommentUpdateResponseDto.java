package io.sparta.board.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class CommentUpdateResponseDto {

  private UUID id;
  private UUID postId;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}

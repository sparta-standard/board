package io.sparta.board.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {
  private UUID id;
  private String title;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private List<CommentResponseDto> comments;

}

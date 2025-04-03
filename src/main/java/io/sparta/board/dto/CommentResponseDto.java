package io.sparta.board.dto;


import io.sparta.board.entity.Comment;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
  private UUID id;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public static CommentResponseDto fromEntity(Comment comment) {
    return CommentResponseDto.builder()
        .id(comment.getId())
        .content(comment.getContent())
        .createdAt(comment.getCreatedAt())
        .updatedAt(comment.getUpdatedAt())
        .build();
  }

}

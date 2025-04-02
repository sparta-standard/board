package io.sparta.board.application.dto.response;

import io.sparta.board.domain.entity.Comment;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentCreateResponseDto {

  private UUID id;
  private UUID postId;
  private String content;
  private LocalDateTime createdAt;

  public CommentCreateResponseDto(Comment comment) {
    this.id = comment.getId();
    this.postId = comment.getPostId();
    this.content = comment.getContent();
    this.createdAt = comment.getCreatedAt();
  }
}

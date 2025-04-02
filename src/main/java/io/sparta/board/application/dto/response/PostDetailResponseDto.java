package io.sparta.board.application.dto.response;

import io.sparta.board.domain.entity.Post;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDetailResponseDto {

  private UUID id;
  private String title;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public static PostDetailResponseDto toResponse(Post post) {
    return new PostDetailResponseDto(
        post.getId(),
        post.getTitle(),
        post.getContent(),
        post.getCreatedAt(),
        post.getUpdatedAt()
    );
  }
}

package io.sparta.board.application.dto.response;

import io.sparta.board.domain.entity.Post;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateResponseDto {

  private UUID id;
  private String title;
  private String content;
  private LocalDateTime updatedAt;

  public PostUpdateResponseDto(Post post) {
    this.id = post.getId();
    this.title = post.getTitle();
    this.content = post.getContent();
    this.updatedAt = post.getUpdatedAt();
  }
}

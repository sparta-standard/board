package io.sparta.board.presentaion;

import io.sparta.board.domain.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@NoArgsConstructor
public class PostResponseDto {

  @Id
  private UUID id;

  private String title;

  private String content;

  private Boolean deleted;

  @CreatedDate
  @Column(nullable = false , updatable = false)
  private LocalDateTime created_at;

  @LastModifiedDate
  @Column
  private LocalDateTime updated_at;

  public PostResponseDto(Post post) {
    this.id = post.getId();
    this.title = post.getTitle();
    this.content = post.getContent();
    this.deleted = post.getDeleted();
    this.created_at = post.getCreated_at();
    this.updated_at = post.getUpdated_at();
  }
}

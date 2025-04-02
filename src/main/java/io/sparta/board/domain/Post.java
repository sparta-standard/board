package io.sparta.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="p_post")
public class Post {

  @Id
  @GeneratedValue
  @Column(nullable = false)
  private UUID id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  private Boolean deleted;

  @CreatedDate
  @Column(nullable = false , updatable = false)
  private LocalDateTime created_at;

  @LastModifiedDate
  @Column
  private LocalDateTime updated_at;

  public Post(String title, String content) {
    this.title = title;
    this.content = content;
  }
  public void update(String title, String content) {
    this.title = title;
    this.content = content;
  }
}

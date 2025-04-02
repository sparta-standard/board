package io.sparta.board.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="p_comment")
public class Comment {

  @Id
  @Column(nullable = false)
  private UUID id;

  @Column(nullable = false)
  private UUID post_id;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private Boolean deleted;

  @CreatedDate
  @Column(nullable = false , updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime created_at;

  @CreatedDate
  @Column(nullable = false , updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime updated_at;
}

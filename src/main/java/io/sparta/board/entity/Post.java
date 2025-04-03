package io.sparta.board.entity;

import io.sparta.board.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "p_post")
public class Post extends BaseEntity {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(columnDefinition = "uuid", updatable = false)
  private UUID id;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(nullable = false,columnDefinition = "TEXT")
  private String content;

  @Column(nullable = false)
  @Builder.Default
  private boolean deleted = false;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  @Builder.Default
  private List<Comment> comments = new ArrayList<>();

  // 편의 메서드 (댓글 연관관계 관리용)


  public void addComment(Comment comment) {
    comments.add(comment);
    comment.setPost(this);
  }

  // 비지니스 로직
  public void update(String title, String content){
    this.title = title;
    this.content = content;
  }

  public void softDelete() {
    this.deleted = true;
    comments.forEach(Comment::softDelete); // 댓글도 함께 soft-delete
  }



}

package io.sparta.board.model.post.entity;

import io.sparta.board.common.BaseEntity;
import io.sparta.board.domain.post.dto.request.PostUpdateRequestDto;
import io.sparta.board.model.comment.entity.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "p_post")
public class Post extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updatePost(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

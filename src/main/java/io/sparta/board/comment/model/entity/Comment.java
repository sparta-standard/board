package io.sparta.board.comment.model.entity;

import io.sparta.board.common.auditing.BaseEntity;
import io.sparta.board.post.model.entity.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "p_comment")
@NoArgsConstructor
@Getter
@Entity
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Builder(access = AccessLevel.PRIVATE)
    private Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }

    public static Comment createComment(String content, Post post) {
        return Comment.builder()
            .content(content)
            .post(post)
            .build();
    }

    public void updateComment(String content) {
        this.content = content;
    }
}

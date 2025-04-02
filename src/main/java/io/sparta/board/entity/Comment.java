package io.sparta.board.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "p_comment")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "comment_id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", nullable=false)
    private Post post;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean deleted = false;

    public void update(String content) {
        this.content = content;
    }

    public void softDelete() {
        this.deleted = true;
    }

    public static Comment toEntity(Post post, String content) {
        return Comment.builder()
                .post(post)
                .content(content)
                .deleted(false)
                .build();
    }
}
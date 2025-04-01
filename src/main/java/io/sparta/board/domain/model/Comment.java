package io.sparta.board.domain.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "p_comment")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public void update(Comment comment) {
        this.content = comment.content;
    }
}

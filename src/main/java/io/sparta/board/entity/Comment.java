package io.sparta.board.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "p_comment")
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", nullable=false)
    private Post post;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean deleted = false;

}

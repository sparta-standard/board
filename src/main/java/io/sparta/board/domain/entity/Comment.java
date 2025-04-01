package io.sparta.board.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Entity
@Table(name="p_comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity{

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String content;

    @JoinColumn(name="post_id")
    @ManyToOne
    private Post post;

    @Builder
    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }
}

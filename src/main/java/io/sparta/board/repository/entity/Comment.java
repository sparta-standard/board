package io.sparta.board.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
public class Comment extends BaseEntity {
    @UuidGenerator
    @Id
    private UUID id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    public static Comment createComment(Board board, String content) {
        Comment comment = new Comment();
        comment.content = content;
        comment.board = board;

        return comment;
    }

    public void updateComment(Comment comment, String content) {
        comment.content = content;
    }
}

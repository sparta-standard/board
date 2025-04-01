package io.sparta.board.repository.entity;

import io.sparta.board.controller.dto.CreateCommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
public class Comment extends BaseEntity {
    @UuidGenerator
    @Id
    UUID id;

    @Column
    String content;

    @Column
    UUID post_id;

    public static Comment createComment(UUID post_id, String content) {
        Comment comment = new Comment();
        comment.post_id = post_id;
        comment.content = content;

        return comment;
    }

    public void updateComment(Comment comment, String content) {
        comment.content = content;
    }
}

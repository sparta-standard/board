package io.sparta.board.comment.model;

import io.sparta.board.common.BaseEntity;
import io.sparta.board.post.model.Post;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "p_comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id",  nullable = false)
    private Post post;

    @Column(length = 512,  nullable = false)
    private String content;


    @Builder
    public Comment(Post post, String content) {
        this.post = post;
        this.content = content;
    }

    public void updateComment(String content) {
        this.content = content;
    }
}

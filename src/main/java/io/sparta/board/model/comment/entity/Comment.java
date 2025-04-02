package io.sparta.board.model.comment.entity;

import io.sparta.board.common.BaseEntity;
import io.sparta.board.model.post.entity.Post;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "p_comment")
public class Comment extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)//cascade 제약조건 추가. db 변경을 고려하면 좋진 않은거 같은데...콘솔로 직접 입력하고 싶은데 어디 있나요...
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Builder
    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }

    public void UpdateComment(String content) {
        this.content = content;
    }

}

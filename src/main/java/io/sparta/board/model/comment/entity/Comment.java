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
@Builder
@AllArgsConstructor
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
    @OnDelete(action = OnDeleteAction.CASCADE)//Hibernate 문법...cascade 제약조건 추가. db 변경을 고려하면 ddl을 직접 작성하는게 좋을 것 같지만 콘솔이 안보인다...
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

}

package io.sparta.board.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity // entity 클래스임을 명시, 해당 클래스에는 기본 키가 포함되어 있어야 한다.
@Table(name = "p_comment")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends BaseEntity {
    @Id
    @UuidGenerator
    private UUID id;
    // *** 조건: post id 가 삭제되면 해당 댓글도 같이 삭제되어야 함.
    // (상이한 id) 댓글 여러 개를 갖을 수 있는 post
    // 1. comment:post 는 다대일의 관계로 정의
    // *** 다대다로 정의할수도 있지 않나? 하나의 게시글에 여러 개의 댓글이 존재할 수 있고,
    // id 가 상이한 여러 개의 댓글이 id 가 상이한 여러 개의 게시글에 존재할 수 있으므로...?
    // 다대일과 다대다를 정의하는 기준이 헷갈림.

    // @JoinColumn 어노테이션이 작성된 엔터티가 db 에서 fk 를 갖는 테이블이 된다.
    @ManyToOne
    @JoinColumn(name = "post_id")
    @Setter
    private Post post;
    private String content; // TEXT
}

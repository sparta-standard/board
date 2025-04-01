package io.sparta.board.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity // entity 클래스임을 명시, 해당 클래스에는 기본 키가 포함되어 있어야 한다.
@Table(name = "p_post")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class Post extends BaseEntity {
    @Id
    @UuidGenerator // @UuidGenerator, @GeneratedValue(strategy = GenerationType.IDENTITY) 차이
    private UUID id;
    @Setter
    private String title; // VARCHAR(100)
    @Setter
    private String content; // TEXT 타입

    // Post 를 기준으로 (현재 클래스가 기준) Post 대 Comment 는 1대다 의 관계
    // 1대다 인데 요청할 때만 데이터를 (해당 post 에 달린 댓글들) 가져올 수 있도록 FetchType.LAZY 설정
    // *** 에러: '일대다' 속성 타입은 컨테이너여야 합니다 --> 리스트 타입으로 하니 에러가 없어짐
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> comments;

    public void delete() {
        this.deleted = true;
    }

    public void addComment(Comment comment) {
        comment.setPost(this);
        log.info("comment: {}", comment.toString());
        this.comments.add(comment);
    }
}

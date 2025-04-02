package io.sparta.board.post.model.entity;

import io.sparta.board.common.auditing.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "p_post")
@NoArgsConstructor
@Getter
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Builder(access = AccessLevel.PRIVATE)
    private Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Post createPost(String title, String content) {
        return Post.builder()
            .title(title)
            .content(content)
            .build();
    }

    public void updatePost(
        String title,
        String content
    ) {
        if (title != null) this.title = title;
        if (content != null) this.content = content;
    }
}

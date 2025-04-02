package io.sparta.board.entity;

import io.sparta.board.dto.request.PostCreateRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "p_post")
public class Post extends BaseEntity {

    @Id
    @Column(name = "post_id", nullable = false)
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean deleted = false;

    public static Post toEntity(PostCreateRequestDto dto) {
        return Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .deleted(false)
                .build();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void softDelete() {
        this.deleted = true;
    }

}

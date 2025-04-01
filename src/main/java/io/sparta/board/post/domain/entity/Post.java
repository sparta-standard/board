package io.sparta.board.post.domain.entity;

import io.sparta.board.post.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Builder
@Table(name = "p_post")
@NoArgsConstructor
@AllArgsConstructor
@SQLRestriction("deleted IS false")
public class Post extends BaseEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    public void updateFromDto(PostUpdateRequestDto requestDto) {
        if (requestDto.getTitle() != null && !requestDto.getTitle().isEmpty()) {
            this.title = requestDto.getTitle();
        }

        if (requestDto.getContent() != null && !requestDto.getContent().isEmpty()) {
            this.content = requestDto.getContent();
        }

    }
}

package io.sparta.board.comment.domain.entity;

import io.sparta.board.comment.application.dto.request.CommentUpdateRequestDto;
import io.sparta.board.global.BaseEntity;
import io.sparta.board.post.domain.entity.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "p_comment")
public class Comment extends BaseEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public void updateFromDto(CommentUpdateRequestDto requestDto) {
        if (requestDto.getContent() != null && !requestDto.getContent().isEmpty()) {
            this.content = requestDto.getContent();
        }
    }
}

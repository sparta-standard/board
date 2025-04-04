package io.sparta.board.model.entity;

import io.sparta.board.presentation.dto.request.UpdateCommentRequestDto;
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
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Table(name = "p_comment")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause= "deleted=false")
@SQLDelete(sql = "UPDATE p_comment SET deleted=true WHERE id")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID commentId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false)
    private boolean deleted;

    @Builder
    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }

    public void update(UpdateCommentRequestDto requestDto) {
        this.content = requestDto.getContent();
    }


    void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void softDelete() {
        this.deleted = true;
    }
}

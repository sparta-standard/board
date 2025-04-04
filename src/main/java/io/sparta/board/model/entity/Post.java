package io.sparta.board.model.entity;

import io.sparta.board.presentation.dto.request.UpdatePostRequestDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Entity
@Table(name = "p_post")
@SQLDelete(sql = "UPDATE p_post SET deleted=true WHERE id")
@Where(clause= "deleted=false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID postId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> comments;

    @Column(nullable = false)
    private boolean deleted;

    @Builder
    public Post(boolean deleted, String title, String content, List<Comment> comments) {
        this.title = title;
        this.content = content;
        this.comments = comments;
    }

    public void update(UpdatePostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void softDelete() {
        this.deleted = true;
        for (Comment c : comments) {
            c.setDeleted(true);
        }
    }


}

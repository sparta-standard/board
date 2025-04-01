package io.sparta.board.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE p_comment SET deleted = true WHERE id = ?")
@Entity
@Table(name = "p_comment")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public void addPost(Post post) {
        this.post = post;
    }

    public void update(String content) {
        this.content = content;
    }
}

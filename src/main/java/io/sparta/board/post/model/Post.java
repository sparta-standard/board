package io.sparta.board.post.model;

import io.sparta.board.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "p_post")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 512,  nullable = false)
    private String content;

    @Column
    private Long count;

    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.count = 0L;
    }

    public void updatePost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void upCount(){
        this.count = this.count + 1;
    }

}

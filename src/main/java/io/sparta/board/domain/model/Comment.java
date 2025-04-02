package io.sparta.board.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.sparta.board.application.dto.request.CommentUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "p_comments")
@NoArgsConstructor
public class Comment extends Default{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    Long Id;

    @Column(nullable = false)
    String content;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", insertable = true)
    Post post;

    @Builder
    public Comment(String content, Post post){
        this.content = content;
        this.post = post;
    }
    public void updateComment(CommentUpdateRequestDto requestDto) {
        this.content = requestDto.content();
    }

}

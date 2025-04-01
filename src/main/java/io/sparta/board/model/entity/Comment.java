package io.sparta.board.model.entity;

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
import lombok.Getter;

@Getter
@Table(name = "p_comment")
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID commentId;

    @Column(nullable = false)
    String content;

    @Column(nullable = false)
    boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;



}

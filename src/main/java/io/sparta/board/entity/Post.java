package io.sparta.board.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "p_post")
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean deleted = false;

}

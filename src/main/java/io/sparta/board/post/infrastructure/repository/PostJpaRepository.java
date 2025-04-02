package io.sparta.board.post.infrastructure.repository;

import io.sparta.board.post.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostJpaRepository extends JpaRepository<Post, UUID> {
}
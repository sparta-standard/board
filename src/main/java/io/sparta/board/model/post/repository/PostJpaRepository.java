package io.sparta.board.model.post.repository;

import io.sparta.board.model.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostJpaRepository extends JpaRepository<Post, UUID> {
}

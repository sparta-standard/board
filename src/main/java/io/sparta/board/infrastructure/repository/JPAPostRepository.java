package io.sparta.board.infrastructure.repository;

import io.sparta.board.model.entity.Post;
import io.sparta.board.model.repository.PostRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAPostRepository extends JpaRepository<Post, Long> , PostRepository {
}

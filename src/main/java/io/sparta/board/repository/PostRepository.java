package io.sparta.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.sparta.board.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}

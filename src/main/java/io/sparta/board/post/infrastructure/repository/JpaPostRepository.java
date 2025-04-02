package io.sparta.board.post.infrastructure.repository;

import io.sparta.board.post.model.entity.Post;
import io.sparta.board.post.model.repository.PostRepository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends JpaRepository<Post, UUID>, PostRepository {

}

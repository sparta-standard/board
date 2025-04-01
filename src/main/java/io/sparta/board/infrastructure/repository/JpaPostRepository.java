package io.sparta.board.infrastructure.repository;

import io.sparta.board.model.entity.Post;
import io.sparta.board.model.repository.PostRepository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends JpaRepository<Post, UUID>, PostRepository {

}

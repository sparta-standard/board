package io.sparta.board.domain.repository;

import io.sparta.board.domain.entity.Post;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, UUID> {

}

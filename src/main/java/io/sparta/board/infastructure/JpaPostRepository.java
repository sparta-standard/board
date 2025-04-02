package io.sparta.board.infastructure;

import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.repository.PostRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostRepository extends JpaRepository<Post, Long> , PostRepository {
}

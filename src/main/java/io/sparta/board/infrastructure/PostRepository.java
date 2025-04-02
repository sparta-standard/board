package io.sparta.board.infrastructure;

import io.sparta.board.domain.Post;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, UUID> {


}

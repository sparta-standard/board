package io.sparta.board.post.repository;

import io.sparta.board.post.model.Post;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    Optional<Post> findByIdAndIsDeletedFalse(UUID postId);

    Page<Post> findAllAndIsDeletedFalse(Pageable pageable);
}

package io.sparta.board.infrastructure.repository;

import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public void save(Post post) {

        jpaPostRepository.save(post);
    }

    @Override
    public Optional<Post> findById(UUID postId) {

        return jpaPostRepository.findById(postId);
    }
}

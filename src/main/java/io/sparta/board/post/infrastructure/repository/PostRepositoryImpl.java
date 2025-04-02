package io.sparta.board.post.infrastructure.repository;

import io.sparta.board.post.domain.entity.Post;
import io.sparta.board.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final PostJpaRepository postJpaRepository;

    @Override
    public Post save(Post post) {
        return postJpaRepository.save(post);
    }

    @Override
    public Optional<Post> findById(UUID postId) {
        return postJpaRepository.findById(postId);
    }

    @Override
    public List<Post> findAll() {
        return postJpaRepository.findAll();
    }
}
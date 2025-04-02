package io.sparta.board.model.post.repository;

import io.sparta.board.model.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository{

    private final PostJpaRepository postJpaRepository;

    @Override
    public Post save(Post post) {
        return postJpaRepository.save(post);
    }

    @Override
    public Optional<Post> findByIdAndDeletedIsFalse(UUID id) {
        return postJpaRepository.findByIdAndDeletedIsFalse(id);
    }

    @Override
    public Boolean existsByTitle(String title) {
        return postJpaRepository.existsByTitle(title);
    }
}

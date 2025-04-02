package io.sparta.board.infrastructure.repository;

import io.sparta.board.domain.entity.Post;
import io.sparta.board.domain.repository.PostRepository;
import io.sparta.board.infrastructure.repository.jpa.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
    public Post findByPostId(UUID id){return postJpaRepository.findById(id).orElse(null);}
}

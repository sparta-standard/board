package io.sparta.board.application.usecase;

import io.sparta.board.model.entity.Post;
import io.sparta.board.model.repository.PostRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPost(UUID postId) {
        return postRepository.findById(postId)
            .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
    }
}

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
    public UUID createPost(Post post) {
        Post savedPost = postRepository.save(post);
        return savedPost.getId();
    }
}

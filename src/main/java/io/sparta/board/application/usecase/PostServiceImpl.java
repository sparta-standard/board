package io.sparta.board.application.usecase;

import io.sparta.board.model.entity.Post;
import io.sparta.board.model.repository.PostRepository;
import io.sparta.board.presentation.dto.request.PostUpdateRequestDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Transactional
    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPost(UUID postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        isDeleted(post);
        return post;
    }

    @Transactional
    @Override
    public void updatePost(Post post, PostUpdateRequestDto requestDto) {
        isDeleted(post);
        requestDto.updatePost(post);
    }

    @Transactional
    @Override
    public void deletePost(Post post) {
        isDeleted(post);
        post.delete();
    }

    private void isDeleted(Post post) {
        if (post.isDeleted()) {
            throw new IllegalArgumentException("삭제된 게시글입니다.");
        }
    }
}

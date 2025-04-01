package io.sparta.board.domain.service;

import io.sparta.board.application.dto.post.CreatePostInternalDto;
import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostDomainService {

    private final PostRepository postRepository;

    public void createPost(Post post) {

        postRepository.save(post);
    }

    public Post findPostById(UUID postId) {

       return postRepository.findById(postId)
               .orElseThrow(() -> new IllegalArgumentException("등록된 게시글이 없습니다: " + postId));
    }
}

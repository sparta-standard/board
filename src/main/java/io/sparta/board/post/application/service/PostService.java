package io.sparta.board.post.application.service;

import io.sparta.board.post.application.dto.request.PostCreateRequestDto;
import io.sparta.board.post.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.post.application.dto.response.PostCreateResponseDto;
import io.sparta.board.post.application.dto.response.PostSearchResponseDto;
import io.sparta.board.post.application.dto.response.PostUpdateResponseDto;
import io.sparta.board.post.domain.entity.Post;
import io.sparta.board.post.domain.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostCreateResponseDto createPost(PostCreateRequestDto requestDto) {
        Post post = Post.builder()
            .title(requestDto.getTitle())
            .content(requestDto.getContent())
            .build();

        postRepository.save(post);

        return PostCreateResponseDto.builder()
            .postId(post.getId())
            .title(post.getTitle())
            .content(post.getContent())
            .build();
    }

    public PostSearchResponseDto searchPost(UUID postId) {
        Post post = findPost(postId);
        return PostSearchResponseDto.builder()
            .postId(post.getId())
            .title(post.getTitle())
            .content(post.getContent())
            .build();
    }

    @Transactional
    public PostUpdateResponseDto updatePost(UUID postId, PostUpdateRequestDto requestDto) {
        Post post = findPost(postId);
        post.updateFromDto(requestDto);
        postRepository.save(post);

        return PostUpdateResponseDto.builder()
            .postId(post.getId())
            .title(post.getTitle())
            .content(post.getContent())
            .build();
    }

    @Transactional
    public void deletePost(UUID postId) {
        Post post = findPost(postId);
        post.delete();
        postRepository.save(post);

    }

    public Post findPost(UUID postId) {
        return postRepository.findById(postId)
            .orElseThrow(() -> new EntityNotFoundException("id에 해당하는 post 를 찾을 수 없습니다. postId : " + postId));
    }
}

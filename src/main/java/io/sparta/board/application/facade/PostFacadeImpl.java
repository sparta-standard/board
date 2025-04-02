package io.sparta.board.application.facade;

import io.sparta.board.application.usecase.PostService;
import io.sparta.board.model.entity.Post;
import io.sparta.board.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.presentation.dto.request.PostUpdateRequestDto;
import io.sparta.board.presentation.dto.response.PostResponseDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostFacadeImpl implements PostFacade {

    private final PostService postService;

    @Override
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        Post savedPost = postService.createPost(requestDto.createPost());
        return PostResponseDto.toResponseDto(savedPost);
    }

    @Override
    public PostResponseDto getPost(UUID postId) {
        Post post = postService.getPost(postId);
        postService.isDeleted(post);
        return PostResponseDto.toResponseDto(post);
    }

    @Override
    public PostResponseDto updatePost(UUID postId, PostUpdateRequestDto requestDto) {
        Post post = postService.getPost(postId);
        postService.isDeleted(post);
        postService.updatePost(post, requestDto);
        return PostResponseDto.toResponseDto(post);
    }

    @Override
    public void deletePost(UUID postId) {
        Post post = postService.getPost(postId);
        postService.isDeleted(post);
        postService.deletePost(post);
    }
}

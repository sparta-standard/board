package io.sparta.board.application.facade;

import io.sparta.board.application.usecase.PostService;
import io.sparta.board.model.entity.Post;
import io.sparta.board.presentation.dto.request.PostCreateRequestDto;
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
        return PostResponseDto.toResponseDto(post);
    }
}

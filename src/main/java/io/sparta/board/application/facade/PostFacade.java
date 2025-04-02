package io.sparta.board.application.facade;

import io.sparta.board.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.presentation.dto.request.PostUpdateRequestDto;
import io.sparta.board.presentation.dto.response.PostResponseDto;
import java.util.UUID;

public interface PostFacade {

    PostResponseDto createPost(PostCreateRequestDto requestDto);

    PostResponseDto getPost(UUID postId);

    PostResponseDto updatePost(UUID postId, PostUpdateRequestDto requestDto);

    void deletePost(UUID postId);
}

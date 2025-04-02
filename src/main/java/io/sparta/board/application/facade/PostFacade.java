package io.sparta.board.application.facade;

import io.sparta.board.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.presentation.dto.request.PostUpdateRequestDto;
import io.sparta.board.presentation.dto.response.PostResponseDto;
import java.util.UUID;
import org.springframework.data.domain.Pageable;

public interface PostFacade {

    PostResponseDto createPost(PostCreateRequestDto requestDto);

    PostResponseDto getPost(UUID postId, Pageable pageable);

    PostResponseDto updatePost(UUID postId, PostUpdateRequestDto requestDto);

    void deletePost(UUID postId);
}

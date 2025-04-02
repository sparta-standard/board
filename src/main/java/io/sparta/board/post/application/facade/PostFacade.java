package io.sparta.board.post.application.facade;

import io.sparta.board.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.post.presentation.dto.request.PostUpdateRequestDto;
import io.sparta.board.post.presentation.dto.response.PostResponseDto;
import java.util.UUID;
import org.springframework.data.domain.Pageable;

public interface PostFacade {

    PostResponseDto createPost(PostCreateRequestDto requestDto);

    PostResponseDto getPost(UUID postId, Pageable pageable);

    PostResponseDto updatePost(UUID postId, PostUpdateRequestDto requestDto);

    void deletePost(UUID postId);
}

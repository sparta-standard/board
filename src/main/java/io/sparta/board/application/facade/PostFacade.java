package io.sparta.board.application.facade;

import io.sparta.board.presentation.dto.PostCreateRequestDto;
import io.sparta.board.presentation.dto.PostResponseDto;

public interface PostFacade {
    PostResponseDto createPost(PostCreateRequestDto requestDto);
}

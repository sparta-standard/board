package io.sparta.board.application.facade;

import io.sparta.board.presentation.dto.PostCreateRequestDto;
import io.sparta.board.presentation.dto.PostResponseDto;
import io.sparta.board.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.presentation.dto.response.PostResponseDto;

public interface PostFacade {
    PostResponseDto createPost(PostCreateRequestDto requestDto);
}

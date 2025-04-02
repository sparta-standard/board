package io.sparta.board.application.service;

import io.sparta.board.presentation.dto.request.CreatePostRequestDto;
import io.sparta.board.presentation.dto.request.UpdatePostRequestDto;
import io.sparta.board.presentation.dto.response.CreatePostResponseDto;
import io.sparta.board.presentation.dto.response.UpdatePostResponseDto;

public interface PostService {

    CreatePostResponseDto createPost(CreatePostRequestDto requestDto);

    UpdatePostResponseDto updatePost(UpdatePostRequestDto requestDto);

}

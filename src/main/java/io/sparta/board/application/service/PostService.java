package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.PostCreateRequestDto;
import io.sparta.board.application.dto.response.PostCreateResponseDto;

public interface PostService {

  PostCreateResponseDto createPost(PostCreateRequestDto requestDto);
}

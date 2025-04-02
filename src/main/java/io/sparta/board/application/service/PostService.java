package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.PostCreateRequestDto;
import io.sparta.board.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.application.dto.response.PostCreateResponseDto;
import io.sparta.board.application.dto.response.PostDetailResponseDto;
import io.sparta.board.application.dto.response.PostUpdateResponseDto;
import java.util.UUID;

public interface PostService {

  PostCreateResponseDto createPost(PostCreateRequestDto requestDto);

  PostUpdateResponseDto updatePost(UUID id, PostUpdateRequestDto requestDto);

  void deletePost(UUID id);

  PostDetailResponseDto getPost(UUID id);
}

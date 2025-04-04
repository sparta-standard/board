package io.sparta.board.application.service;

import io.sparta.board.model.entity.Comment;
import io.sparta.board.presentation.dto.request.CreatePostRequestDto;
import io.sparta.board.presentation.dto.request.UpdatePostRequestDto;
import io.sparta.board.presentation.dto.response.CreatePostResponseDto;
import io.sparta.board.presentation.dto.response.GetPostResponseDto;
import io.sparta.board.presentation.dto.response.UpdatePostResponseDto;
import java.util.List;
import java.util.UUID;

public interface PostService {

    CreatePostResponseDto createPost(CreatePostRequestDto requestDto);

    UpdatePostResponseDto updatePost(UUID postId, UpdatePostRequestDto requestDto);

    Void deletePost(UUID postId);

    GetPostResponseDto getPost(UUID postId);
}

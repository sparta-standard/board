package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.application.dto.request.CommentUpdateRequestDto;
import io.sparta.board.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.application.dto.response.CommentUpdateResponseDto;
import java.util.UUID;

public interface CommentService {

  CommentCreateResponseDto createComment(UUID postId, CommentCreateRequestDto requestDto);

  CommentUpdateResponseDto updateComment(UUID postId, UUID id, CommentUpdateRequestDto requestDto);
}

package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.application.dto.response.CommentCreateResponseDto;
import java.util.UUID;

public interface CommentService {

   CommentCreateResponseDto createComment(UUID postId,
      CommentCreateRequestDto requestDto);
}

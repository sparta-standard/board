package io.sparta.board.application.service;

import io.sparta.board.presentation.dto.request.CreateCommentRequestDto;
import io.sparta.board.presentation.dto.response.CreateCommentResponseDto;

public interface CommentService {

    CreateCommentResponseDto createComment(CreateCommentRequestDto RequestDto);

}

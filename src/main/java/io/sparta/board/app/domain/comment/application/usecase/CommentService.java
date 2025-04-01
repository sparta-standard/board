package io.sparta.board.app.domain.comment.application.usecase;

import io.sparta.board.app.domain.comment.presentation.dto.request.CommentCreateRequestDto;
import io.sparta.board.app.domain.comment.presentation.dto.response.CommentCreateResponseDto;

public interface CommentService {

	CommentCreateResponseDto createComment(CommentCreateRequestDto commentCreateRequestDto);
}

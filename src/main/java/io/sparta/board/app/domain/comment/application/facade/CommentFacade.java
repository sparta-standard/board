package io.sparta.board.app.domain.comment.application.facade;

import io.sparta.board.app.domain.comment.presentation.dto.request.CommentCreateRequestDto;
import io.sparta.board.app.domain.comment.presentation.dto.response.CommentCreateResponseDto;

public interface CommentFacade {
	CommentCreateResponseDto createComment(CommentCreateRequestDto commentCreateRequestDto);

}

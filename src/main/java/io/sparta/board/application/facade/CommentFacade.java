package io.sparta.board.application.facade;

import io.sparta.board.presentation.dto.request.CommentCreateRequestDto;
import io.sparta.board.presentation.dto.response.CommentResponseDto;
import java.util.UUID;

public interface CommentFacade {

    CommentResponseDto createComment(CommentCreateRequestDto requestDto, UUID postId);
}

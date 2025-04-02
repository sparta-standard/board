package io.sparta.board.comment.application.facade;

import io.sparta.board.comment.presentation.dto.request.CommentCreateRequestDto;
import io.sparta.board.comment.presentation.dto.request.CommentUpdateRequestDto;
import io.sparta.board.comment.presentation.dto.response.CommentResponseDto;
import java.util.UUID;

public interface CommentFacade {

    CommentResponseDto createComment(CommentCreateRequestDto requestDto, UUID postId);

    CommentResponseDto updateComment(UUID commentId, CommentUpdateRequestDto requestDto);

    void deleteComment(UUID commentId);
}

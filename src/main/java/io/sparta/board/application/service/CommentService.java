package io.sparta.board.application.service;

import io.sparta.board.presentation.dto.request.CreateCommentRequestDto;
import io.sparta.board.presentation.dto.request.UpdateCommentRequestDto;
import io.sparta.board.presentation.dto.response.CreateCommentResponseDto;
import java.util.UUID;

public interface CommentService {

    CreateCommentResponseDto createComment(CreateCommentRequestDto RequestDto);

    Void updateComment(UUID commentId, UpdateCommentRequestDto RequestDto);

    Void deleteComment(UUID commentId);

}

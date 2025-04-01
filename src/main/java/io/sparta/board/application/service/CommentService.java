package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.application.dto.request.CommentUpdateRequestDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentService {
    public void createComment(UUID postId, CommentCreateRequestDto dto) {
    }

    public void updateComment(UUID postId, UUID commentId, CommentUpdateRequestDto dto) {
    }

    public void deleteComment(UUID postId, UUID commentId) {
    }
}

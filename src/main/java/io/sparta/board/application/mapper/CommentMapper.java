package io.sparta.board.application.mapper;

import io.sparta.board.application.dto.request.CommentRequestDto;
import io.sparta.board.application.dto.response.CommentResponseDto;
import io.sparta.board.domain.entity.Comment;

public class CommentMapper {

    public static Comment toEntity(CommentRequestDto dto) {
        return Comment.builder()
                .commentContent(dto.getCommentContent())
                .build();
    }

    public static CommentResponseDto.CommentData toCommentData(Comment comment) {
        return CommentResponseDto.CommentData.builder()
                .commentId(comment.getCommentId())
                .commentContent(comment.getCommentContent())
                .build();
    }
}
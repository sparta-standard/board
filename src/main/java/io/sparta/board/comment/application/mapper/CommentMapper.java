package io.sparta.board.comment.application.mapper;

import io.sparta.board.comment.domain.entity.Comment;
import io.sparta.board.post.application.dto.request.CommentRequestDto;
import io.sparta.board.post.application.dto.response.CommentResponseDto;

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
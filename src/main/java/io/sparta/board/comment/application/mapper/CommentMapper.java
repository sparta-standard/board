package io.sparta.board.comment.application.mapper;

import io.sparta.board.comment.application.dto.request.CommentRequestDto;
import io.sparta.board.comment.application.dto.response.CommentResponseDto;
import io.sparta.board.comment.domain.entity.Comment;
import io.sparta.board.post.domain.entity.Post;

public class CommentMapper {

    public static Comment toEntity(CommentRequestDto dto, Post post) {
        return Comment.builder()
                .commentContent(dto.getCommentContent())
                .post(post)
                .build();
    }

    public static CommentResponseDto.CommentData toCommentData(Comment comment) {
        return CommentResponseDto.CommentData.builder()
                .commentId(comment.getCommentId())
                .commentContent(comment.getCommentContent())
                .build();
    }
}
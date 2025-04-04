package io.sparta.board.presentation.mapper;

import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.entity.Post;
import io.sparta.board.presentation.dto.CommentDto;
import io.sparta.board.presentation.dto.request.CreateCommentRequestDto;
import io.sparta.board.presentation.dto.response.CreateCommentResponseDto;

public class CommentMapper {


    public static Comment createCommentRequestDtoToEntity(Post post, CreateCommentRequestDto requestDto) {
        Comment comment = Comment.builder()
                .post(post)
                .content(requestDto.getContent())
                .build();
        return comment;
    }

    public static CreateCommentResponseDto entityToCreateCommentresponseDto(Comment comment) {
        CreateCommentResponseDto responseDto = CreateCommentResponseDto.builder()
                .commentId(comment.getCommentId())
                .content(comment.getContent())
                .build();
        return responseDto;
    }


    public static CommentDto entityToCommentDto(Comment comment) {
        CommentDto commentDto = CommentDto.builder()
                .commentId(comment.getCommentId())
                .content(comment.getContent())
                .build();
        return commentDto;
    }
}

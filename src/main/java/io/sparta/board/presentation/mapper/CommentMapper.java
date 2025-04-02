package io.sparta.board.presentation.mapper;

import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.entity.Post;
import io.sparta.board.presentation.dto.request.CreateCommentRequestDto;
import io.sparta.board.presentation.dto.request.CreatePostRequestDto;
import io.sparta.board.presentation.dto.response.CreateCommentResponseDto;
import io.sparta.board.presentation.dto.response.CreatePostResponseDto;
import io.sparta.board.presentation.dto.response.UpdatePostResponseDto;

public class CommentMapper {


    public static Comment createCommentRequestDtoToEntity(CreateCommentRequestDto requestDto) {
        Comment comment = Comment.builder()
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




}

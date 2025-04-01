package io.sparta.board.application.dto.mapper;

import io.sparta.board.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.application.dto.response.comment.CommentDeleteResponseDto;
import io.sparta.board.application.dto.response.comment.CommentUpdateResponseDto;
import io.sparta.board.domain.entity.Comment;

public class CommentMapper {

    public static CommentCreateResponseDto toCommentCreateResponseDto(Comment comment){
        return CommentCreateResponseDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .build();
    }

    public static CommentUpdateResponseDto toCommentUpdateResponseDto(Comment comment){
        return CommentUpdateResponseDto.builder()
                .content(comment.getContent())
                .build();
    }

    public static CommentDeleteResponseDto toCommentDeleteResponseDto(Comment comment){
        return CommentDeleteResponseDto.builder()
                .id(comment.getId())
                .build();
    }
}

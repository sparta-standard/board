package io.sparta.board.application.mapper;

import io.sparta.board.application.dto.comment.CommentResponseInternalDto;
import io.sparta.board.application.dto.comment.CreateCommentRequestInternalDto;
import io.sparta.board.domain.model.Comment;

import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {

    public static Comment toEntity(CreateCommentRequestInternalDto request){

        return Comment.builder()
                .content(request.getContent())
                .build();
    }

    public static CommentResponseInternalDto toResponse(Comment comment){

        return CommentResponseInternalDto.builder()
                .id(comment.getId())
                .createdAt(comment.getCreatedAt())
                .content(comment.getContent())
                .build();
    }

    public static List<CommentResponseInternalDto> toResponseList(List<Comment> comments){

        if(comments == null) return null;

        return comments.stream()
                .map(CommentMapper::toResponse)
                .collect(Collectors.toList());
    }
}

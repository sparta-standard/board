package io.sparta.board.application.mapper;

import io.sparta.board.application.dto.comment.CommentResponseInternalDto;
import io.sparta.board.application.dto.comment.CommentRequestInternalDto;
import io.sparta.board.domain.model.Comment;
import org.springframework.data.domain.Page;

public class CommentMapper {

    public static Comment toEntity(CommentRequestInternalDto request) {

        return Comment.builder()
                .content(request.getContent())
                .build();
    }

    public static CommentResponseInternalDto toResponse(Comment comment) {

        return CommentResponseInternalDto.builder()
                .id(comment.getId())
                .createdAt(comment.getCreatedAt())
                .content(comment.getContent())
                .build();
    }

    public static Page<CommentResponseInternalDto> toResponsePage(Page<Comment> comments) {

        return comments.map(CommentMapper::toResponse);
    }
}

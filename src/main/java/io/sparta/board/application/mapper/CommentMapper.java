package io.sparta.board.application.mapper;

import io.sparta.board.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.application.dto.response.CommentGetResponseDto;
import io.sparta.board.domain.entity.Comment;
import io.sparta.board.domain.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentGetResponseDto toDto(Comment comment) {
        return CommentGetResponseDto.builder()
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }

    public Comment toEntity(CommentCreateRequestDto dto, Post post) {
        return Comment.builder()
                .content(dto.content())
                .post(post)
                .build();
    }
}

package io.sparta.board.application.mapper;

import io.sparta.board.application.dto.response.CommentGetResponseDto;
import io.sparta.board.domain.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentGetResponseDto toDto(Comment comment) {
        return CommentGetResponseDto.builder()
                .content(comment.getContent())
                .createdAt(comment.getCreateAt())
                .build();
    }
}

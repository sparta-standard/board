package io.sparta.board.presentation.mapper;

import io.sparta.board.application.dto.comment.CommentResponseInternalDto;
import io.sparta.board.application.dto.comment.CreateCommentRequestInternalDto;
import io.sparta.board.presentation.dto.comment.CommentResponseDto;
import io.sparta.board.presentation.dto.comment.CreateCommentRequestDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class CommentDtoMapper {

    public static CreateCommentRequestInternalDto toInternalDto(CreateCommentRequestDto request) {

        return CreateCommentRequestInternalDto.builder()
                .content(request.getContent())
                .build();
    }

    public static CommentResponseDto toResponse(CommentResponseInternalDto dto) {

        return CommentResponseDto.builder()
                .id(dto.getId())
                .createdAt(dto.getCreatedAt())
                .content(dto.getContent())
                .build();
    }

    public static List<CommentResponseDto> toResponseList(List<CommentResponseInternalDto> dtoList) {

        if (dtoList == null) {
            return null;
        }

        return dtoList.stream()
                .map(CommentDtoMapper::toResponse)
                .collect(Collectors.toList());
    }
}

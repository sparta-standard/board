package io.sparta.board.presentation.mapper;

import io.sparta.board.application.dto.post.PostInternalDto;
import io.sparta.board.application.dto.post.PostResponseInternalDto;
import io.sparta.board.presentation.dto.post.PostRequestDto;
import io.sparta.board.presentation.dto.post.PostResponseDto;
import lombok.Builder;

@Builder
public class PostDtoMapper {

    public static PostInternalDto toInternalDto(PostRequestDto request) {

        return PostInternalDto.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }


    public static PostResponseDto toResponse(PostResponseInternalDto response) {

        return PostResponseDto.builder()
                .id(response.getId())
                .createAt(response.getCreateAt())
                .title(response.getTitle())
                .content(response.getContent())
                .build();
    }

    public static PostResponseDto toResponseWithComments(PostResponseInternalDto response) {

        return PostResponseDto.builder()
                .id(response.getId())
                .createAt(response.getCreateAt())
                .title(response.getTitle())
                .content(response.getContent())
                .comments(CommentDtoMapper.toResponseList(response.getComments().getContent()))
                .build();
    }
}

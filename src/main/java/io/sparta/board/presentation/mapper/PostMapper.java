package io.sparta.board.presentation.mapper;

import io.sparta.board.model.entity.Post;
import io.sparta.board.presentation.dto.request.CreatePostRequestDto;
import io.sparta.board.presentation.dto.request.UpdatePostRequestDto;
import io.sparta.board.presentation.dto.response.CreatePostResponseDto;
import io.sparta.board.presentation.dto.response.UpdatePostResponseDto;

public class PostMapper {

    public static UpdatePostResponseDto entityToUpdatePostResponseDto(Post post) {
        UpdatePostResponseDto responseDto = UpdatePostResponseDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
        return responseDto;
    }

    public static Post createPostRequestDtotoEntity(CreatePostRequestDto requestDto) {

        Post post = Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .deleted(false)
                .build();
        return post;
    }

    public static CreatePostResponseDto entityToCreatePostresponseDto(Post post) {
        CreatePostResponseDto responseDto = CreatePostResponseDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
        return responseDto;
    }




}

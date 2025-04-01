package io.sparta.board.post.application.mapper;

import io.sparta.board.post.application.dto.request.PostRequestDto;
import io.sparta.board.post.application.dto.response.PostResponseDto;
import io.sparta.board.post.domain.entity.Post;

public class PostMapper {

    public static Post toEntity(PostRequestDto dto) {
        return Post.builder()
                .postTitle(dto.getPostTitle())
                .postContent(dto.getPostContent())
                .build();
    }

    public static PostResponseDto.PostData toPostData(Post post) {
        return PostResponseDto.PostData.builder()
                .postId(post.getPostId())
                .postTitle(post.getPostTitle())
                .postContent(post.getPostContent())
                .build();
    }
}
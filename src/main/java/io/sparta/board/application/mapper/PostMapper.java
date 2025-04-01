package io.sparta.board.application.mapper;

import io.sparta.board.application.dto.post.CreatePostInternalDto;
import io.sparta.board.application.dto.post.PostResponseInternalDto;
import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import org.springframework.data.domain.Page;

public class PostMapper {

    public static Post toEntity(CreatePostInternalDto dto) {

        return Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    public static PostResponseInternalDto toResponse(Post post) {

        return PostResponseInternalDto.builder()
                .id(post.getId())
                .createAt(post.getCreatedAt())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public static PostResponseInternalDto toResponseWithComments(Post post, Page<Comment> commentPage) {

        return PostResponseInternalDto.builder()
                .id(post.getId())
                .createAt(post.getCreatedAt())
                .title(post.getTitle())
                .content(post.getContent())
                .comments(CommentMapper.toResponsePage(commentPage))
                .build();
    }
}

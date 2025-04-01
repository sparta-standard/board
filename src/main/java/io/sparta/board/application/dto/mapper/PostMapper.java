package io.sparta.board.application.dto.mapper;

import io.sparta.board.application.dto.response.CommentResponseDto;
import io.sparta.board.application.dto.response.PostCreateResponseDto;
import io.sparta.board.application.dto.response.PostGetResponseDto;
import io.sparta.board.application.dto.response.post.PostDeleteResponseDto;
import io.sparta.board.application.dto.response.post.PostUpdateResponseDto;
import io.sparta.board.domain.entity.Comment;
import io.sparta.board.domain.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostCreateResponseDto toPostCreateResponseDto(Post post) {
        return PostCreateResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public static PostGetResponseDto toPostGetResponseDto(Post post) {
        return PostGetResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .commentList(toCommentResponseList(post.getCommentList()))
                .build();
    }

    private static List<CommentResponseDto> toCommentResponseList(List<Comment> commentList) {
        return commentList.stream()
                .map(PostMapper::toCommentResponse)
                .collect(Collectors.toList());
    }

    private static CommentResponseDto toCommentResponse(Comment comment) {
        return CommentResponseDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }

    public static PostUpdateResponseDto toPostUpdateResponseDto(Post post) {
        return PostUpdateResponseDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public static PostDeleteResponseDto toPostDeleteResponseDto(Post post) {
        return PostDeleteResponseDto.builder()
                .id(post.getId())
                .build();
    }
}

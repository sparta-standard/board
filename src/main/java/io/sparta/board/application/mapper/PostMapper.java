package io.sparta.board.application.mapper;

import io.sparta.board.application.dto.request.PostCreateRequestDto;
import io.sparta.board.application.dto.response.CommentGetResponseDto;
import io.sparta.board.application.dto.response.PostGetResponseDto;
import io.sparta.board.application.dto.response.PostResponseDto;
import io.sparta.board.domain.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostMapper {

    public Post toEntity(PostCreateRequestDto dto) {
        return Post.builder()
                .title(dto.title())
                .content(dto.content())
                .build();
    }

    public PostGetResponseDto toDto(Post post, List<CommentGetResponseDto> commentList) {
        return PostGetResponseDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .comments(commentList)
                .build();
    }

    public PostResponseDto toListDto(Post post) {
        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .createdAt(post.getCreatedAt())
                .build();
    }
}

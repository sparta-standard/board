package io.sparta.board.application.facade;

import io.sparta.board.application.usecase.CommentService;
import io.sparta.board.application.usecase.PostService;
import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.entity.Post;
import io.sparta.board.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.presentation.dto.request.PostUpdateRequestDto;
import io.sparta.board.presentation.dto.response.CommentResponseDto;
import io.sparta.board.presentation.dto.response.PostResponseDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostFacadeImpl implements PostFacade {

    private final PostService postService;
    private final CommentService commentService;

    @Override
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        Post savedPost = postService.createPost(requestDto.createPost());
        return PostResponseDto.toResponseDto(savedPost, null);
    }

    @Override
    public PostResponseDto getPost(UUID postId) {
        Post post = postService.getPost(postId);
        postService.isDeleted(post);
        return PostResponseDto.toResponseDto(post, getComments(postId));
    }

    @Override
    public PostResponseDto updatePost(UUID postId, PostUpdateRequestDto requestDto) {
        Post post = postService.getPost(postId);
        postService.isDeleted(post);
        postService.updatePost(post, requestDto);
        return PostResponseDto.toResponseDto(post, getComments(postId));
    }

    @Override
    public void deletePost(UUID postId) {
        Post post = postService.getPost(postId);
        postService.isDeleted(post);
        postService.deletePost(post);
    }

    private List<CommentResponseDto> getComments(UUID postId) {
        List<Comment> comments = commentService.getComments(postId);
        return comments.stream().map(CommentResponseDto::toResponseDto).toList();
    }
}

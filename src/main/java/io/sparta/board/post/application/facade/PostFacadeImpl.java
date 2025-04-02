package io.sparta.board.post.application.facade;

import io.sparta.board.comment.application.usecase.CommentService;
import io.sparta.board.comment.model.entity.Comment;
import io.sparta.board.comment.presentation.dto.response.CommentResponseDto;
import io.sparta.board.post.application.usecase.PostService;
import io.sparta.board.post.model.entity.Post;
import io.sparta.board.post.presentation.dto.request.PostCreateRequestDto;
import io.sparta.board.post.presentation.dto.request.PostUpdateRequestDto;
import io.sparta.board.post.presentation.dto.response.PostResponseDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostFacadeImpl implements PostFacade {

    private final PostService postService;
    private final CommentService commentService;

    @Override
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        Post savedPost = postService.createPost(requestDto.createPost());
        return PostResponseDto.toResponseDto(savedPost);
    }

    @Override
    public PostResponseDto getPost(UUID postId, Pageable pageable) {
        Post post = postService.getPost(postId);
        postService.isDeleted(post);
        return PostResponseDto.toResponseDto(post, getComments(postId, pageable));
    }

    @Override
    public PostResponseDto updatePost(UUID postId, PostUpdateRequestDto requestDto) {
        Post post = postService.getPost(postId);
        postService.isDeleted(post);
        postService.updatePost(post, requestDto);
        return PostResponseDto.toResponseDto(post);
    }

    @Override
    public void deletePost(UUID postId) {
        Post post = postService.getPost(postId);
        postService.isDeleted(post);
        postService.deletePost(post);
        List<Comment> comments = commentService.getComments(postId);
        commentService.deleteComments(comments);
    }

    private List<CommentResponseDto> getComments(UUID postId, Pageable pageable) {
        List<Comment> comments = commentService.getComments(postId, pageable);
        return comments.stream().map(CommentResponseDto::toResponseDto).toList();
    }
}

package io.sparta.board.comment.application.facade;

import io.sparta.board.comment.application.usecase.CommentService;
import io.sparta.board.comment.model.entity.Comment;
import io.sparta.board.comment.presentation.dto.request.CommentCreateRequestDto;
import io.sparta.board.comment.presentation.dto.request.CommentUpdateRequestDto;
import io.sparta.board.comment.presentation.dto.response.CommentResponseDto;
import io.sparta.board.post.application.usecase.PostService;
import io.sparta.board.post.model.entity.Post;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentFacadeImpl implements CommentFacade {

    private final PostService postService;
    private final CommentService commentService;

    @Override
    public CommentResponseDto createComment(CommentCreateRequestDto requestDto, UUID postId) {
        Post post = postService.getPost(postId);
        postService.isDeleted(post);
        Comment comment = requestDto.createComment(post);
        Comment savedComment = commentService.createComment(comment);
        return CommentResponseDto.toResponseDto(savedComment);
    }

    @Override
    public CommentResponseDto updateComment(UUID commentId, CommentUpdateRequestDto requestDto) {
        Comment comment = commentService.getComment(commentId);
        postService.isDeleted(comment.getPost());
        commentService.isDeleted(comment);
        commentService.updateComment(comment, requestDto);
        return CommentResponseDto.toResponseDto(comment);
    }

    @Override
    public void deleteComment(UUID commentId) {
        Comment comment = commentService.getComment(commentId);
        commentService.isDeleted(comment);
        commentService.deleteComment(comment);
    }
}

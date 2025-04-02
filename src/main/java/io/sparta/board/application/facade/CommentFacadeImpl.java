package io.sparta.board.application.facade;

import io.sparta.board.application.usecase.CommentService;
import io.sparta.board.application.usecase.PostService;
import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.entity.Post;
import io.sparta.board.presentation.dto.request.CommentCreateRequestDto;
import io.sparta.board.presentation.dto.response.CommentResponseDto;
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
        Comment comment = requestDto.createComment(post);
        Comment savedComment = commentService.createComment(comment);
        return CommentResponseDto.toResponseDto(savedComment);
    }
}

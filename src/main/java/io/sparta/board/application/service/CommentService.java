package io.sparta.board.application.service;

import io.sparta.board.application.dto.comment.CommentResponseInternalDto;
import io.sparta.board.application.dto.comment.CreateCommentRequestInternalDto;
import io.sparta.board.application.mapper.CommentMapper;
import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.service.CommentDomainService;
import io.sparta.board.domain.service.PostDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentDomainService commentDomainService;

    private final PostDomainService postDomainService;

    public CommentResponseInternalDto createComment(UUID postId, CreateCommentRequestInternalDto request) {

        Post post = postDomainService.findPostById(postId);

        Comment comment = CommentMapper.toEntity(request);

        comment.addPost(post);

        commentDomainService.createComment(comment);

        return CommentMapper.toResponse(comment);
    }
}

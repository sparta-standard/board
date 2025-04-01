package io.sparta.board.application.service;

import io.sparta.board.application.dto.comment.CommentRequestInternalDto;
import io.sparta.board.application.dto.comment.CommentResponseInternalDto;
import io.sparta.board.application.mapper.CommentMapper;
import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.service.CommentDomainService;
import io.sparta.board.domain.service.PostDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentDomainService commentDomainService;

    private final PostDomainService postDomainService;


    @Transactional
    public CommentResponseInternalDto createComment(UUID postId, CommentRequestInternalDto request) {

        Post post = postDomainService.findPostById(postId);

        Comment comment = CommentMapper.toEntity(request);

        comment.addPost(post);

        commentDomainService.createComment(comment);

        return CommentMapper.toResponse(comment);
    }

    @Transactional
    public CommentResponseInternalDto updateComment(UUID commentId, CommentRequestInternalDto request) {

        Comment comment = commentDomainService.findCommentById(commentId);

        comment.update(request.getContent());

        commentDomainService.update(comment);

        return CommentMapper.toResponse(comment);
    }

    @Transactional
    public CommentResponseInternalDto deleteCommentById(UUID commentId) {

        Comment comment = commentDomainService.findCommentById(commentId);

        commentDomainService.deleteById(commentId);

        return CommentMapper.toResponse(comment);
    }
}

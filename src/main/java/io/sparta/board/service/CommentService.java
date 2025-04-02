package io.sparta.board.service;

import io.sparta.board.dto.comment.CommentRequestDto;
import io.sparta.board.dto.comment.CommentResponseDto;
import io.sparta.board.entity.Comment;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.CommentRepository;
import io.sparta.board.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 작성
    @Transactional
    public CommentResponseDto addComment(UUID postId, CommentRequestDto requestDto) {
        Post post = findPost(postId);
        Comment comment = new Comment(post, requestDto);
        Comment saveComment = commentRepository.save(comment);
        return CommentResponseDto.from(saveComment);
    }

    // 수정
    @Transactional
    public CommentResponseDto updateComment(UUID postId, UUID commentId, CommentRequestDto requestDto) {
        findPost(postId);
        Comment comment = findComment(commentId);
        comment.updateComment(requestDto);
        return CommentResponseDto.from(comment);
    }

    // 삭제
    @Transactional
    public UUID deleteComment(UUID postId, UUID commentId) {
        findPost(postId);
        Comment comment = findComment(commentId);
        comment.softDelete();
        return commentId;
    }

    private Post findPost(UUID postId) {
        return postRepository.findByIdAndDeletedFalse(postId).orElseThrow(() ->
                new EntityNotFoundException("해당 게시글이 존재하지 않습니다.")
        );
    }

    private Comment findComment(UUID commentId) {
        return commentRepository.findByIdAndDeletedFalse(commentId).orElseThrow(() ->
                new EntityNotFoundException("해당 댓글이 존재하지 않습니다.")
        );
    }
}

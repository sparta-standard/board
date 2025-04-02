package io.sparta.board.service;

import io.sparta.board.dto.request.CommentCreateRequestDto;
import io.sparta.board.dto.request.CommentUpdateRequestDto;
import io.sparta.board.dto.response.CommentDetailResponseDto;
import io.sparta.board.entity.Comment;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.CommentRepository;
import io.sparta.board.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<CommentDetailResponseDto> getCommentsByPost(UUID postId) {
        List<Comment> comments = commentRepository.findAllByPostIdAndDeletedFalse(postId);
        return comments.stream()
                .map(CommentDetailResponseDto::new)
                .toList();
    }

    @Transactional
    public CommentDetailResponseDto createComment(UUID postId, CommentCreateRequestDto dto) {
        Post post = postRepository.findByIdAndDeletedFalse(postId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시물입니다"));

        Comment comment = Comment.toEntity(post, dto.getContent());
        Comment saved = commentRepository.save(comment);

        return new CommentDetailResponseDto(saved);
    }

    @Transactional
    public CommentDetailResponseDto updateComment(UUID commentId, CommentUpdateRequestDto dto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 댓글입니다"));

        if (comment.isDeleted()) {
            throw new IllegalStateException("이미 삭제된 댓글입니다");
        }

        comment.update(dto.getContent());
        return new CommentDetailResponseDto(comment);
    }

    @Transactional
    public void deleteComment(UUID commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 댓글입니다"));

        if (comment.isDeleted()) {
            throw new IllegalStateException("이미 삭제된 댓글입니다");
        }

        comment.softDelete();
    }

}

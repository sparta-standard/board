package io.sparta.board.comment.service;

import io.sparta.board.comment.dto.requestDto.CommentCreateRequestDto;
import io.sparta.board.comment.dto.requestDto.CommentUpdateRequestDto;
import io.sparta.board.comment.dto.responseDto.CommentCreateResponseDto;
import io.sparta.board.comment.dto.responseDto.CommentDeleteResponseDto;
import io.sparta.board.comment.dto.responseDto.CommentUpdateResponseDto;
import io.sparta.board.comment.model.Comment;
import io.sparta.board.comment.repository.CommentRepository;
import io.sparta.board.post.model.Post;
import io.sparta.board.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "Comment Service")
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 댓글 등록
    @Transactional
    public CommentCreateResponseDto createComment(UUID postId, CommentCreateRequestDto requestDto) {

        Post post = postRepository.findByIdAndIsDeletedFalse(postId)
            .orElseThrow(EntityNotFoundException::new);

        Comment comment = Comment.builder()
            .content(requestDto.getContent())
            .post(post)
            .build();

        commentRepository.save(comment);
        return new CommentCreateResponseDto(comment);
    }

    // 댓글 수정
    @Transactional
    public CommentUpdateResponseDto updateComment(UUID commentId, CommentUpdateRequestDto requestDto) {

        Comment comment = commentRepository.findByIdAndIsDeletedFalse(commentId)
            .orElseThrow(EntityNotFoundException::new);

        comment.updateComment(requestDto.getContent());

        return new CommentUpdateResponseDto(comment);
    }

    // 댓글 삭제 (soft delete)
    @Transactional
    public CommentDeleteResponseDto deleteComment(UUID commentId) {
        Comment comment = commentRepository.findByIdAndIsDeletedFalse(commentId)
            .orElseThrow(EntityNotFoundException::new);

        comment.delete();
        return new CommentDeleteResponseDto(commentId, "Successfully deleted comment");
    }
}

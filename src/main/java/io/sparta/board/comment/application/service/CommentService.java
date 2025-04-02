package io.sparta.board.comment.application.service;

import io.sparta.board.comment.application.dto.request.CommentRequestDto;
import io.sparta.board.comment.application.dto.response.CommentListResponseDto;
import io.sparta.board.comment.application.dto.response.CommentResponseDto;
import io.sparta.board.comment.application.mapper.CommentMapper;
import io.sparta.board.comment.domain.entity.Comment;
import io.sparta.board.comment.domain.repository.CommentRepository;
import io.sparta.board.common.exception.ErrorCode;
import io.sparta.board.common.exception.GlobalException;
import io.sparta.board.post.domain.entity.Post;
import io.sparta.board.post.domain.repository.PostRepository;
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

    @Transactional
    public CommentResponseDto createComment(UUID postId, CommentRequestDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new GlobalException(ErrorCode.POST_NOT_FOUND));

        Comment comment = CommentMapper.toEntity(dto, post);
        Comment savedComment = commentRepository.save(comment);

        return CommentResponseDto.builder()
                .message("댓글이 생성되었습니다.")
                .stateCode(201)
                .comment(CommentMapper.toCommentData(savedComment))
                .build();
    }

    @Transactional
    public CommentListResponseDto getCommentsByPostId(UUID postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new GlobalException(ErrorCode.POST_NOT_FOUND));

        List<CommentResponseDto.CommentData> comments = commentRepository.findByPost(post).stream()
                .map(CommentMapper::toCommentData)
                .toList();

        return CommentListResponseDto.builder()
                .message("댓글이 조회되었습니다.")
                .stateCode(200)
                .comments(comments)
                .build();
    }

    @Transactional
    public CommentResponseDto updateComment(UUID postId, UUID commentId, CommentRequestDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new GlobalException(ErrorCode.POST_NOT_FOUND));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new GlobalException(ErrorCode.COMMENT_NOT_FOUND));

        comment.update(dto.getCommentContent());

        return CommentResponseDto.builder()
                .message("댓글이 수정되었습니다.")
                .stateCode(200)
                .comment(CommentMapper.toCommentData(comment))
                .build();
    }

    @Transactional
    public CommentResponseDto deleteComment(UUID postId, UUID commentId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new GlobalException(ErrorCode.POST_NOT_FOUND));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new GlobalException(ErrorCode.COMMENT_NOT_FOUND));

        comment.softDelete();

        return CommentResponseDto.builder()
                .message("댓글이 삭제되었습니다.")
                .stateCode(200)
                .build();
    }
}
package io.sparta.board.comment.application.service;

import io.sparta.board.comment.application.dto.request.CommentRequestDto;
import io.sparta.board.comment.application.dto.response.CommentResponseDto;
import io.sparta.board.comment.application.mapper.CommentMapper;
import io.sparta.board.comment.domain.entity.Comment;
import io.sparta.board.comment.domain.repository.CommentRepository;
import io.sparta.board.post.domain.entity.Post;
import io.sparta.board.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public CommentResponseDto createComment(UUID postId, CommentRequestDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        Comment comment = CommentMapper.toEntity(dto, post);
        Comment savedComment = commentRepository.save(comment);

        return CommentResponseDto.builder()
                .message("댓글이 생성되었습니다.")
                .stateCode(201)
                .comment(CommentMapper.toCommentData(savedComment))
                .build();
    }
}
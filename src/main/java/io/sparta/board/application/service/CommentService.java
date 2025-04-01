package io.sparta.board.application.service;

import io.sparta.board.application.dto.mapper.CommentMapper;
import io.sparta.board.application.dto.request.comment.CommentCreateRequestDto;
import io.sparta.board.application.dto.request.comment.CommentUpdateRequestDto;
import io.sparta.board.application.dto.response.comment.CommentCreateResponseDto;
import io.sparta.board.application.dto.response.comment.CommentDeleteResponseDto;
import io.sparta.board.application.dto.response.comment.CommentUpdateResponseDto;
import io.sparta.board.domain.entity.Comment;
import io.sparta.board.domain.entity.Post;
import io.sparta.board.domain.repository.CommentRepository;
import io.sparta.board.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentCreateResponseDto createComment(UUID id, CommentCreateRequestDto request){
        Post post = postRepository.findByPostId(id);

        Comment comment = request.toEntity(post);
        Comment savedComment = commentRepository.save(comment);

        CommentCreateResponseDto response = CommentMapper.toCommentCreateResponseDto(savedComment);

        return response;
    }

    @Transactional
    public CommentUpdateResponseDto updateComment(UUID id, CommentUpdateRequestDto request) {
        Comment comment = commentRepository.findById(id);

        if(comment.isDeleted()){
            throw new IllegalArgumentException("삭제된 댓글입니다.");
        }

        comment.update(request.getContent());

        return CommentMapper.toCommentUpdateResponseDto(comment);
    }

    @Transactional
    public CommentDeleteResponseDto deleteComment(UUID id) {
        Comment comment = commentRepository.findById(id);
        if(comment.isDeleted()){
            throw new IllegalArgumentException("삭제된 댓글입니다.");
        }

        comment.softDelete();

        return CommentMapper.toCommentDeleteResponseDto(comment);
    }
}

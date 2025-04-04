package io.sparta.board.application.service;

import io.sparta.board.exception.CustomException;
import io.sparta.board.exception.ExceptionCode;
import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.entity.Post;
import io.sparta.board.model.repository.CommentRepository;
import io.sparta.board.model.repository.PostRepository;
import io.sparta.board.presentation.dto.request.CreateCommentRequestDto;
import io.sparta.board.presentation.dto.request.UpdateCommentRequestDto;
import io.sparta.board.presentation.dto.response.CreateCommentResponseDto;
import io.sparta.board.presentation.mapper.CommentMapper;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    @Override
    public CreateCommentResponseDto createComment(UUID postid, CreateCommentRequestDto RequestDto) {
        Post post = postRepository.findById(postid).orElseThrow(() -> new CustomException(
                ExceptionCode.POST_NOT_FOUND));
        Comment comment = CommentMapper.createCommentRequestDtoToEntity(post, RequestDto);
        commentRepository.save(comment);
        return CommentMapper.entityToCreateCommentresponseDto(comment);
    }

    @Override
    public Void updateComment(UUID commentId, UpdateCommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CustomException(
                ExceptionCode.COMMENT_NOT_FOUND));
        comment.update(requestDto);
        return null;
    }

    @Override
    public Void deleteComment(UUID commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CustomException(
                ExceptionCode.COMMENT_NOT_FOUND));
        comment.softDelete();
        return null;
    }
}

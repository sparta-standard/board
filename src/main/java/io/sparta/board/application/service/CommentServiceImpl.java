package io.sparta.board.application.service;

import io.sparta.board.exception.CustomException;
import io.sparta.board.exception.ExceptionCode;
import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.repository.CommentRepository;
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


    @Override
    public CreateCommentResponseDto createComment(CreateCommentRequestDto RequestDto) {
        Comment comment = CommentMapper.createCommentRequestDtoToEntity(RequestDto);
        commentRepository.save(comment);
        return CommentMapper.entityToCreateCommentresponseDto(comment);
    }

    @Override
    public Void updateComment(UUID commentId, UpdateCommentRequestDto RequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CustomException(
                ExceptionCode.COMMENT_NOT_FOUND));
        return null;
    }
}

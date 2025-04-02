package io.sparta.board.application.service;

import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.repository.CommentRepository;
import io.sparta.board.presentation.dto.request.CreateCommentRequestDto;
import io.sparta.board.presentation.dto.response.CreateCommentResponseDto;
import io.sparta.board.presentation.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl extends CommentService {
    private final CommentRepository commentRepository;


    @Override
    public CreateCommentResponseDto createComment(CreateCommentRequestDto RequestDto) {
        Comment comment = CommentMapper.createCommentRequestDtoToEntity(RequestDto);
        commentRepository.save(comment);
        CreateCommentResponseDto responseDto = CommentMapper.entityToCreateCommentresponseDto(comment);
        return responseDto;
    }
}

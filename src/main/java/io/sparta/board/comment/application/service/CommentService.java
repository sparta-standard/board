package io.sparta.board.comment.application.service;

import io.sparta.board.board.application.service.BoardService;
import io.sparta.board.board.domain.entity.Board;
import io.sparta.board.comment.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.comment.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.comment.domain.entity.Comment;
import io.sparta.board.comment.domain.repository.CommentRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardService boardService;

    public CommentCreateResponseDto createComment(UUID boardId, CommentCreateRequestDto requestDto) {
        Board board = boardService.findBoard(boardId);

        Comment comment = Comment.builder()
            .board(board)
            .content(requestDto.getContent())
            .build();

        commentRepository.save(comment);

        return CommentCreateResponseDto.builder()
            .boardId(board.getId())
            .commentId(comment.getId())
            .content(comment.getContent())
            .build();
    }
}

package io.sparta.board.service;

import io.sparta.board.controller.dto.CreateCommentRequestDto;
import io.sparta.board.controller.dto.UpdateCommentRequestDto;
import io.sparta.board.repository.BoardRepository;
import io.sparta.board.repository.CommentRepository;
import io.sparta.board.repository.entity.Board;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import io.sparta.board.repository.entity.Comment;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void createComment(CreateCommentRequestDto createCommentRequestDto) {
        Board board = boardRepository.findByTitle(createCommentRequestDto.getTitle());

        Comment comment = Comment.createComment(board.getId(), createCommentRequestDto.getContent());
        commentRepository.save(comment);
    }

    @Transactional
    public void updateComment(UpdateCommentRequestDto updateCommentRequestDto) {
        Comment comment = commentRepository.findById(updateCommentRequestDto.getId()).orElseThrow();
        comment.updateComment(comment ,updateCommentRequestDto.getContent());
    }

    @Transactional
    public void deleteComment(UUID id) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        comment.delete();
    }
}

package io.sparta.board.service;

import io.sparta.board.controller.dto.CreateBoardRequestDto;
import io.sparta.board.controller.dto.GetBoardResponseDto;
import io.sparta.board.controller.dto.UpdateBoardRequestDto;
import io.sparta.board.repository.BoardRepository;
import io.sparta.board.repository.CommentRepository;
import io.sparta.board.repository.entity.Board;
import io.sparta.board.repository.entity.Comment;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void createBoard(CreateBoardRequestDto createBoardRequestDto) {
        Board board = Board.createBoard(createBoardRequestDto);
        boardRepository.save(board);
    }

    @Transactional
    public void updateBoard(String title, UpdateBoardRequestDto updateBoardRequestDto) {
        Board board = boardRepository.findByTitle(title);
        Board.updateBoard(board, updateBoardRequestDto);
    }

    @Transactional
    public void deleteBoard(String title) {
        Board board = boardRepository.findByTitle(title);
        board.delete();

        List<Comment> comments = commentRepository.findByBoardId(board.getId());
        for (Comment comment : comments) {
            System.out.println(comment.getId());
            comment.delete();
        }
    }

    @Transactional
    public GetBoardResponseDto getBoard(String title) {
        Board board = boardRepository.findByTitle(title);
        List<Comment> comments = commentRepository.findByBoardId(board.getId());

        return new GetBoardResponseDto(title, comments);
    }

    public Page<Board> getBoards(int page, int size) {
        if (size != 10 && size != 30 && size != 50) {
            size = 10;
        }

        Pageable pageable = PageRequest.of(page, size);
        return boardRepository.findAll(pageable);
    }
}

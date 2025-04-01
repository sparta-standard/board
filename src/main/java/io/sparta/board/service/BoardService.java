package io.sparta.board.service;

import io.sparta.board.controller.dto.CreateBoardRequestDto;
import io.sparta.board.controller.dto.UpdateBoardRequestDto;
import io.sparta.board.repository.BoardRepository;
import io.sparta.board.repository.entity.Board;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

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
    }
}

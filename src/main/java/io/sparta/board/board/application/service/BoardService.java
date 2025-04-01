package io.sparta.board.board.application.service;

import io.sparta.board.board.application.dto.request.BoardCreateRequestDto;
import io.sparta.board.board.application.dto.response.BoardCreateResponseDto;
import io.sparta.board.board.application.dto.response.BoardSearchResponseDto;
import io.sparta.board.board.domain.entity.Board;
import io.sparta.board.board.domain.repository.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardCreateResponseDto createBoard(BoardCreateRequestDto requestDto) {
        Board board = Board.builder()
            .title(requestDto.getTitle())
            .content(requestDto.getContent())
            .build();

        boardRepository.save(board);

        return BoardCreateResponseDto.builder()
            .boardId(board.getId())
            .title(board.getTitle())
            .content(board.getContent())
            .build();
    }

    public BoardSearchResponseDto searchBoard(UUID boardId) {
        Board board = boardRepository.findById(boardId)
            .orElseThrow(() -> new EntityNotFoundException("id에 해당하는 board 를 찾을 수 없습니다. boardId : " + boardId));

        return BoardSearchResponseDto.builder()
            .boardId(board.getId())
            .title(board.getTitle())
            .content(board.getContent())
            .build();
    }
}

package io.sparta.board.board.application.service;

import io.sparta.board.board.application.dto.request.BoardCreateRequestDto;
import io.sparta.board.board.application.dto.response.BoardCreateResponseDto;
import io.sparta.board.board.domain.entity.Board;
import io.sparta.board.board.domain.repository.BoardRepository;
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

}

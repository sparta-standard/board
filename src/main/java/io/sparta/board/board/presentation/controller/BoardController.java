package io.sparta.board.board.presentation.controller;

import io.sparta.board.board.application.dto.request.BoardCreateRequestDto;
import io.sparta.board.board.application.dto.response.BoardCreateResponseDto;
import io.sparta.board.board.application.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public ResponseEntity<BoardCreateResponseDto> createBoard(
        @RequestBody BoardCreateRequestDto requestDto
    ) {
        BoardCreateResponseDto responseDto = boardService.createBoard(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }



}

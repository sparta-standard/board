package io.sparta.board.board.presentation.controller;

import io.sparta.board.board.application.dto.request.BoardCreateRequestDto;
import io.sparta.board.board.application.dto.request.BoardUpdateRequestDto;
import io.sparta.board.board.application.dto.response.BoardCreateResponseDto;
import io.sparta.board.board.application.dto.response.BoardSearchResponseDto;
import io.sparta.board.board.application.service.BoardService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/boards/{boardId}")
    public ResponseEntity<BoardSearchResponseDto> searchBoardFromId(
        @PathVariable(name = "boardId") UUID boardId
    ) {
        BoardSearchResponseDto responseDto = boardService.searchBoard(boardId);
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping("/boards/{boardId}")
    public ResponseEntity<BoardUpdateResponseDto> updateBoard(
        @PathVariable(name = "boardId") UUID boardId,
        @RequestBody BoardUpdateRequestDto requestDto
    ) {
        BoardUpdateResponseDto responseDto = boardService.updateBoard(boardId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

}

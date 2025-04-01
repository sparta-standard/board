package io.sparta.board.presentation.controller;
import io.sparta.board.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.application.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@Slf4j
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{id}")
    public ResponseEntity<CommentCreateResponseDto> create(@RequestBody Map<String, String> request, @PathVariable UUID id) {
        CommentCreateResponseDto responseDto = commentService.create(id, request);
        return ResponseEntity.ok().body(responseDto);
    }

}

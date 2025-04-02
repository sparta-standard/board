package io.sparta.board.presentation;

import io.sparta.board.application.dto.request.CommentRequestDto;
import io.sparta.board.application.dto.request.CommentUpdateRequestDto;
import io.sparta.board.application.dto.response.CommentResponseDto;
import io.sparta.board.application.dto.response.CommentUpdateResponseDto;
import io.sparta.board.application.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<Void> createComment(@RequestBody CommentRequestDto requestDto) {
        Long commentId = commentService.createComment(requestDto);

        URI location = UriComponentsBuilder
                .fromUriString("/api/v1/comments/{id}")
                .buildAndExpand(commentId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentUpdateResponseDto> modifyComment(@PathVariable Long id,
                                                                  @RequestBody CommentUpdateRequestDto requestDto) {
        CommentUpdateResponseDto responseDto = commentService.modifyComment(id,requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> getComment(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getComment(id));
    }
}

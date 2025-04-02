package io.sparta.board.controller;

import io.sparta.board.controller.dto.CreateCommentRequestDto;
import io.sparta.board.controller.dto.UpdateCommentRequestDto;
import io.sparta.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 등록
    @PostMapping("")
    public String createComment(@RequestBody CreateCommentRequestDto createCommentRequestDto) {
        commentService.createComment(createCommentRequestDto);

        return "댓글이 등록되었습니다!";
    }

    // 댓글 수정
    @PatchMapping("")
    public String updateComment(@RequestBody UpdateCommentRequestDto updateCommentRequestDto) {
        commentService.updateComment(updateCommentRequestDto);

        return "댓글이 수정되었습니다!";
    }

    // 댓글 삭제
    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable UUID id) {
        commentService.deleteComment(id);

        return "댓글이 삭제되었습니다!";
    }
}

package io.sparta.board.controller;

import io.sparta.board.controller.dto.CreateBoardRequestDto;
import io.sparta.board.controller.dto.UpdateBoardRequestDto;
import io.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public String CreateBoard(@RequestBody CreateBoardRequestDto createBoardRequestDto){
        boardService.createBoard(createBoardRequestDto);

        return "게시글이 등록되었습니다!";
    }

    @PostMapping("/{title}")
    public String UpdateBoard(@PathVariable String title, @RequestBody UpdateBoardRequestDto updateBoardRequestDto){
        boardService.updateBoard(title, updateBoardRequestDto);

        return "게시글이 수정되었습니다!";
    }

    @DeleteMapping("/{title}")
    public String DeleteBoard(@PathVariable String title){
        boardService.deleteBoard(title);

        return "게시글이 삭제되었습니다!";
    }
}

package io.sparta.board.controller;

import io.sparta.board.controller.dto.CreateBoardRequestDto;
import io.sparta.board.controller.dto.GetBoardResponseDto;
import io.sparta.board.controller.dto.UpdateBoardRequestDto;
import io.sparta.board.repository.entity.Board;
import io.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 등록
    @PostMapping("")
    public String CreateBoard(@RequestBody CreateBoardRequestDto createBoardRequestDto){
        boardService.createBoard(createBoardRequestDto);

        return "게시글이 등록되었습니다!";
    }

    // 게시글 수정
    @PostMapping("/{title}")
    public String UpdateBoard(@PathVariable("title") String title, @RequestBody UpdateBoardRequestDto updateBoardRequestDto){
        boardService.updateBoard(title, updateBoardRequestDto);

        return "게시글이 수정되었습니다!";
    }

    // 게시글 삭제
    @DeleteMapping("/{title}")
    public String DeleteBoard(@PathVariable("title") String title){
        boardService.deleteBoard(title);

        return "게시글이 삭제되었습니다!";
    }

    // 게시글 단건조회
    @GetMapping("/{title}")
    public GetBoardResponseDto GetBoard(@PathVariable("title") String title){
        return boardService.getBoard(title);
    }

    // 게시글 페이징조회
    @GetMapping("")
    public Page<Board> GetBoards(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false, defaultValue = "10") int size){
        return boardService.getBoards(page, size);
    }


}

package io.sparta.board.presentation.controller;

import io.sparta.board.application.dto.request.PostCreationRequestDto;
import io.sparta.board.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.application.dto.response.DeletePostResponseDto;
import io.sparta.board.application.dto.response.PostCreationResponseDto;
import io.sparta.board.application.dto.response.PostUpdateResponseDto;
import io.sparta.board.application.dto.response.ShowPostOneResponseDto;
import io.sparta.board.application.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Slf4j
public class PostController {
    private final PostService postService;

    /* 통신 확인용
    @GetMapping
    public String home() {
        log.info("GET /post");
        return "GET /post";
    }
    */

    @PostMapping
    public ResponseEntity<PostCreationResponseDto> create(@Valid @RequestBody PostCreationRequestDto dto) {
        log.info("Post Method - 게시글 작성: dto = {}", dto.toString());
        PostCreationResponseDto responseDto = postService.create(dto);
        return ResponseEntity.ok().body(responseDto);
    }

    // *** @PathVariable 로 전달받은 값을 dto 에 포함할 수 있을까?
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody PostUpdateRequestDto dto, @PathVariable UUID id) {
        log.info("Patch Method - 게시글 수정: dto = {}", dto.toString());
        try{
            PostUpdateResponseDto updateDto = postService.update(dto, id);
            return ResponseEntity.ok().body(updateDto);
        }catch (Exception e){
            HashMap<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    // 게시글 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeletePostResponseDto> delete(@PathVariable UUID id) {
        log.info("Delete Method - 게시글 삭제");
        DeletePostResponseDto delete = postService.delete(id);
        return ResponseEntity.ok().body(delete);
    }

    // 게시글 조회
    @GetMapping("/{id}")
    public ResponseEntity<ShowPostOneResponseDto> findOnePost(
            @PathVariable UUID id
            /* 페이지네이션이 어떻게 구현되는지 모르겠다.
            pageNo 라는 key 로 전달된 값을 int 타입 pageNo 변수에 담는다.
            pageNo 는 클라이언트로부터 필수로 전달되어야할 파라미터가 아니다: required = false
            @RequestParam(required = false, defaultValue = "10", name = "pageNo") int pageNo*/) {
        log.info("Get Method - 게시글 조회");
        // Pageable pageable = PageRequest.of(pageNo);
        ShowPostOneResponseDto onePost = postService.findOnePost(id);
        return ResponseEntity.ok().body(onePost);
    }
}

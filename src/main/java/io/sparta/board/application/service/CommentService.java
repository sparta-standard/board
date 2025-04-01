package io.sparta.board.application.service;

import io.sparta.board.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;

    public CommentCreateResponseDto create(UUID id, Map<String, String> request) {
        // 1. 게시물 존재 여부 확인
        Post post = postService.getPost(id);

        // 2. 클라이언트가 전달한 데이터 여부 확인
        String content = request.get("content");
        log.info("content: {}", content);
        // isBlank() 는 빈문자열("")과 공백으로만 채워진 문자열을 검증하는 역할, isEmpty() 는 공백으로만 채워진 문자열을 필터하지 못함.
        if(content.isBlank()) throw new IllegalArgumentException("댓글 내용은 필수입니다.");

        Comment comment = Comment.builder()
                .content(content)
                .post(post)
                .build();

        Comment saved = commentRepository.save(comment);
        return new CommentCreateResponseDto(saved);
    }
}

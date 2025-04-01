package io.sparta.board.application.service;

import io.sparta.board.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.application.dto.response.CommentUpdateResponseDto;
import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;

    public CommentCreateResponseDto create(UUID postId, Map<String, String> request) {
        // 1. 게시물 존재 여부 확인
        Post post = postService.getPost(postId);

        // 2. 클라이언트가 전달한 데이터 여부 확인
        // isBlank() 는 빈문자열("")과 공백으로만 채워진 문자열을 검증하는 역할, isEmpty() 는 공백으로만 채워진 문자열을 필터하지 못함.
        if(request.isEmpty() || request.get("content").isBlank()) throw new IllegalArgumentException("댓글 내용은 필수입니다.");

        String content = request.get("content");

        Comment comment = Comment.builder()
                .content(content)
                .post(post)
                .build();

        Comment saved = commentRepository.save(comment);
        return new CommentCreateResponseDto(saved);
    }

    @Transactional
    public CommentUpdateResponseDto update(UUID commentId, Map<String, String> request) {
        // 1. 댓글 존재 여부 확인
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));

        // 2. 클라이언트가 전달한 데이터 여부 확인
        // isBlank() 는 null, 빈문자열("")과 공백으로만 채워진 문자열을 검증하는 역할, isEmpty() 는 공백으로만 채워진 문자열을 필터하지 못함.
        // if(HashMap 타입 참조변수 == null) 이 아닌 HashMap 타입 참조변수는 isEmpty() 로 null 체크해야하는 것 같음
        if(request.isEmpty() || request.get("content").isBlank()) throw new IllegalArgumentException("댓글 내용은 필수입니다.");

        String content = request.get("content");

        if(!comment.getContent().equals(content)) {
            comment.setContent(content);
        }
        Comment updateComment = commentRepository.save(comment);
        return new CommentUpdateResponseDto(updateComment);
    }
}

package io.sparta.board.comment.service;

import io.sparta.board.comment.dto.CommentRequestDto;
import io.sparta.board.comment.dto.CommentResponseDto;
import io.sparta.board.comment.model.Comment;
import io.sparta.board.post.entity.Post;
import io.sparta.board.comment.repository.CommentRepository;
import io.sparta.board.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 댓글 등록
    public CommentResponseDto createComment(UUID postId, CommentRequestDto requestDto) {

        Post post = postRepository.findByIdAndDeletedFalse(postId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        Comment comment = new Comment(requestDto, post);
        Comment savedComment = commentRepository.save(comment);

        return new CommentResponseDto(savedComment);
    }

}

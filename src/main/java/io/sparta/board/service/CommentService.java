package io.sparta.board.service;

import io.sparta.board.dto.CommentRequestDto;
import io.sparta.board.dto.CommentResponseDto;
import io.sparta.board.entity.Comment;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.CommentRepository;
import io.sparta.board.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public CommentResponseDto addComment(UUID postId, CommentRequestDto requestDto) {
        Post post = findPost(postId);
        Comment comment = new Comment(post, requestDto);
        Comment saveComment = commentRepository.save(comment);
        return CommentResponseDto.from(saveComment);
    }

    private Post findPost(UUID postId) {
        return postRepository.findByIdAndDeletedFalse(postId).orElseThrow(() ->
                new EntityNotFoundException("해당 게시글이 존재하지 않습니다.")
        );
    }
}

package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.application.dto.request.CommentUpdateRequestDto;
import io.sparta.board.application.mapper.CommentMapper;
import io.sparta.board.domain.entity.Comment;
import io.sparta.board.domain.entity.Post;
import io.sparta.board.domain.repository.CommentRepository;
import io.sparta.board.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CommentMapper commentMapper;

    @Transactional
    public void createComment(UUID postId, CommentCreateRequestDto dto) {
        Post post = getPostById(postId);
        commentRepository.save(commentMapper.toEntity(dto, post));
    }

    @Transactional
    public void updateComment(UUID postId, UUID commentId, CommentUpdateRequestDto dto) {
        Post post = getPostById(postId);
        Comment comment = getCommentById(commentId);

        comment.updateOf(dto);
    }

    @Transactional
    public void deleteComment(UUID postId, UUID commentId) {
        Post post = getPostById(postId);
        Comment comment = getCommentById(commentId);

        comment.deletedOf();
    }


    public Post getPostById(UUID id) {
        return postRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new RuntimeException("해당 게시물이 존재하지 않습니다."));
    }

    public Comment getCommentById(UUID id) {
        return commentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new RuntimeException("해당 댓글이 존재하지 않습니다."));
    }
}

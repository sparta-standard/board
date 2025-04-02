package io.sparta.board.service;

import io.sparta.board.dto.CommentRequestDto;
import io.sparta.board.dto.CommentResponseDto;
import io.sparta.board.entity.Comment;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.CommentRepository;
import io.sparta.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public CommentResponseDto createComment(CommentRequestDto req, UUID postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."));

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setContent(req.getContent());

        Comment savedComment = commentRepository.save(comment);
        return toResponseDto(savedComment);
    }



    public CommentResponseDto updateComment(UUID commentId, CommentRequestDto req) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "댓글을 찾을 수 없습니다."));

        if (comment.isDeleted()) {
            throw new ResponseStatusException(HttpStatus.GONE, "삭제된 댓글입니다.");
        }

        comment.setContent(req.getContent());
        Comment updatedComment = commentRepository.save(comment);
        return toResponseDto(updatedComment);
    }

    public void deleteComment(UUID commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "댓글을 찾을 수 없습니다."));

        comment.setDeleted(true);
        commentRepository.save(comment);
    }

    private CommentResponseDto toResponseDto(Comment comment) {
        return new CommentResponseDto(
                comment.getId(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }
}

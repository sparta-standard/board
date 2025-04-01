package io.sparta.board.comment.application.service;

import io.sparta.board.comment.application.dto.response.CommentSearchResponseDto;
import io.sparta.board.post.application.service.PostService;
import io.sparta.board.comment.application.dto.request.CommentCreateRequestDto;
import io.sparta.board.comment.application.dto.request.CommentUpdateRequestDto;
import io.sparta.board.comment.application.dto.response.CommentCreateResponseDto;
import io.sparta.board.comment.application.dto.response.CommentUpdateResponseDto;
import io.sparta.board.comment.domain.entity.Comment;
import io.sparta.board.comment.domain.repository.CommentRepository;
import io.sparta.board.post.domain.entity.Post;
import io.sparta.board.post.domain.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public CommentCreateResponseDto createComment(UUID postId, CommentCreateRequestDto requestDto) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new EntityNotFoundException("해당하는 post 를 찾을 수 없습니다 postId : " + postId));

        Comment comment = Comment.builder()
            .post(post)
            .content(requestDto.getContent())
            .build();

        commentRepository.save(comment);

        return CommentCreateResponseDto.builder()
            .postId(post.getId())
            .commentId(comment.getId())
            .content(comment.getContent())
            .build();
    }

    @Transactional
    public CommentUpdateResponseDto updateComment(UUID commentId, CommentUpdateRequestDto requestDto) {
        Comment comment = findComment(commentId);

        comment.updateFromDto(requestDto);
        commentRepository.save(comment);

        return CommentUpdateResponseDto.builder()
            .postId(comment.getPost().getId())
            .commentId(comment.getId())
            .content(comment.getContent())
            .build();
    }

    @Transactional
    public void deleteComment(UUID commentId) {
        Comment comment = findComment(commentId);

        comment.delete();
        commentRepository.save(comment);
    }

    public Comment findComment(UUID commentId) {
        return commentRepository.findById(commentId)
            .orElseThrow(() -> new EntityNotFoundException("해당하는 댓글을 찾을 수 없습니다. 받은 commentId : " + commentId));
    }

    public Page<CommentSearchResponseDto> searchComments(UUID postId, Pageable pageable) {
        Page<Comment> commentPage = commentRepository.findByPostId(postId, pageable);

        return commentPage.map(comment -> CommentSearchResponseDto.builder()
            .postId(comment.getPost().getId())
            .commentId(comment.getId())
            .content(comment.getContent())
            .build()
        );
    }

}

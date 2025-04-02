package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.CommentRequestDto;
import io.sparta.board.application.dto.request.CommentUpdateRequestDto;
import io.sparta.board.application.dto.response.CommentResponseDto;
import io.sparta.board.application.dto.response.CommentUpdateResponseDto;
import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import io.sparta.board.infastructure.JpaCommentRepository;
import io.sparta.board.infastructure.JpaPostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final JpaCommentRepository commentRepository;
    private final JpaPostRepository postRepository;

    public Long createComment(CommentRequestDto requestDto) {
        Post post = findPostById(requestDto.postId());
        Comment comment = commentRepository.save(requestDto.createComment(post));
        return comment.getId();
    }

    public CommentUpdateResponseDto modifyComment(Long id, CommentUpdateRequestDto requestDto) {
        Comment comment = findCommentById(id);
        comment.updateComment(requestDto);
        return CommentUpdateResponseDto.from(comment);
    }

    public CommentResponseDto getComment(Long id) {
        return CommentResponseDto.from(findCommentById(id));
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }


    public Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("존재하지않는 게시글입니다."));
    }

    public Post findPostById(Long id) {
        return postRepository.findById(id).orElseThrow(()-> new NullPointerException("존재하지 않는 게시글입니다."));
    }

}

package io.sparta.board.comment.service;

import io.sparta.board.comment.dto.requestDto.CommentCreateRequestDto;
import io.sparta.board.comment.dto.responseDto.CommentCreateResponseDto;
import io.sparta.board.comment.model.Comment;
import io.sparta.board.comment.repository.CommentRepository;
import io.sparta.board.post.model.Post;
import io.sparta.board.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 댓글 등록
    @Transactional
    public CommentCreateResponseDto createComment(CommentCreateRequestDto requestDto) {

        Post post = postRepository.findById(requestDto.getPostId()).orElseThrow(EntityNotFoundException::new);

        Comment comment = Comment.builder()
            .content(requestDto.getContent())
            .post(post)
            .build();

        commentRepository.save(comment);
        return new CommentCreateResponseDto(comment);
    }

}

package io.sparta.board.service;

import io.sparta.board.dto.request.CommentCreateRequestDto;
import io.sparta.board.dto.response.CommentResponseDto;
import io.sparta.board.entity.Comment;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.CommentRepository;
import io.sparta.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    @Transactional
    public CommentResponseDto createComment(CommentCreateRequestDto requestDto){
        Post post = postRepository.findById(requestDto.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물을 찾을 수 없습니다."));

        Comment comment = new Comment(post, requestDto.getContent());
        Comment savedComment = commentRepository.save(comment);

        return new CommentResponseDto(savedComment);
    }
}

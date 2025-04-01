package io.sparta.board.domain.comment.service;

import io.sparta.board.domain.comment.dto.requeset.CommentCreateRequestDto;
import io.sparta.board.domain.comment.dto.response.CommentResponseDto;
import io.sparta.board.model.comment.entity.Comment;
import io.sparta.board.model.comment.repository.CommentReposiroy;
import io.sparta.board.model.post.entity.Post;
import io.sparta.board.model.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentReposiroy commentReposiroy;

    private final PostRepository postRepository;

    @Transactional
    public CommentResponseDto createComment(
            CommentCreateRequestDto request,
            UUID postId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));

        Comment comment = Comment.builder()
                .content(request.getComment())
                .post(post)
                .build();

        Comment saveComment = commentReposiroy.save(comment);

        return CommentResponseDto.builder()
                .id(saveComment.getId())
                .postId(saveComment.getPost().getId())
                .comment(saveComment.getContent())
                .build();
    }
}

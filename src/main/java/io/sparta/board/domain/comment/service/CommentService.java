package io.sparta.board.domain.comment.service;

import io.sparta.board.domain.comment.dto.requeset.CommentCreateRequestDto;
import io.sparta.board.domain.comment.dto.requeset.CommentUpdateRequestDto;
import io.sparta.board.domain.comment.dto.response.CommentResponseDto;
import io.sparta.board.model.comment.entity.Comment;
import io.sparta.board.model.comment.repository.CommentReposiroy;
import io.sparta.board.model.post.entity.Post;
import io.sparta.board.model.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

        Post post = postRepository.findByIdAndDeletedIsFalse(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));

        Comment comment = Comment.builder()
                .content(request.getComment())
                .post(post)
                .build();

        Comment saveComment = commentReposiroy.save(comment);

        return CommentResponseDto.builder()
                .id(saveComment.getId())
                .postId(saveComment.getPost().getId())
                .content(saveComment.getContent())
                .build();
    }

    public CommentResponseDto updateComment(UUID id, CommentUpdateRequestDto request) {

        Comment existComment = commentReposiroy.findByIdAndDeletedIsFalse(id)
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글"));


        existComment.UpdateComment(request.getContent());

        Comment updateComment = commentReposiroy.save(existComment);

        return CommentResponseDto.builder()
                .id(updateComment.getId())
                .postId(updateComment.getPost().getId())
                .content(updateComment.getContent())
                .build();
    }

    public void deleteComment(UUID id) {

        Comment existComment = commentReposiroy.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new IllegalArgumentException("이미 삭제된 댓글"));

        existComment.setDeleted(true);

        commentReposiroy.save(existComment);

    }

    public List<Comment> getPostComment(UUID id) {

        List<Comment> comments = new ArrayList<>();
        List<Comment> commentList = commentReposiroy.findByPostIdAndDeletedIsFalse(id);

        for (Comment comment : commentList) {
            comments.add(comment);
        }

        return comments;
    }
}

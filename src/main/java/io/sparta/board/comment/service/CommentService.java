package io.sparta.board.comment.service;

import io.sparta.board.comment.dto.requestDto.CommentCreateRequestDto;
import io.sparta.board.comment.dto.requestDto.CommentUpdateRequestDto;
import io.sparta.board.comment.dto.responseDto.CommentCreateResponseDto;
import io.sparta.board.comment.dto.responseDto.CommentDeleteResponseDto;
import io.sparta.board.comment.dto.responseDto.CommentResponseDto;
import io.sparta.board.comment.dto.responseDto.CommentUpdateResponseDto;
import io.sparta.board.comment.model.Comment;
import io.sparta.board.comment.repository.CommentRepository;
import io.sparta.board.common.PageRequestDto;
import io.sparta.board.post.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "Comment Service")
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;

    // 댓글 등록
    @Transactional
    public CommentCreateResponseDto createComment(UUID postId, CommentCreateRequestDto requestDto) {

        Comment comment = Comment.builder()
            .content(requestDto.getContent())
            .post(postService.existsPost(postId))
            .build();

        commentRepository.save(comment);
        return new CommentCreateResponseDto(comment);
    }

    // 댓글 수정
    @Transactional
    public CommentUpdateResponseDto updateComment(UUID commentId, CommentUpdateRequestDto requestDto) {

        Comment comment = commentRepository.findByIdAndIsDeletedFalse(commentId)
            .orElseThrow(EntityNotFoundException::new);

        comment.updateComment(requestDto.getContent());

        return new CommentUpdateResponseDto(comment);
    }

    // 댓글 삭제 (soft delete)
    @Transactional
    public CommentDeleteResponseDto deleteComment(UUID commentId) {
        Comment comment = commentRepository.findByIdAndIsDeletedFalse(commentId)
            .orElseThrow(EntityNotFoundException::new);

        comment.delete();
        return new CommentDeleteResponseDto(commentId, "Successfully deleted comment");
    }

    // 게시물 내 -> 댓글 전체 조회
    public Page<CommentResponseDto> getComments(UUID postId, Integer page, Integer size) {

        Page<Comment> comment = commentRepository.findAllByPostIdAndIsDeletedFalse(
            postId, new PageRequestDto(page,size).getPageable());

        return comment.map(CommentResponseDto::new);
    }

    // 게시물 삭제시 -> 댓글 함께 삭제
    public void deleteAllComments(UUID postId) {
        List<Comment> comments = commentRepository.findAllByPostId(postId);
        comments.forEach(Comment::delete);
    }
}

package io.sparta.board.application.usecase;

import io.sparta.board.model.entity.Comment;
import io.sparta.board.model.repository.CommentRepository;
import io.sparta.board.presentation.dto.request.CommentUpdateRequestDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getComment(UUID commentId) {
        return commentRepository.findById(commentId)
            .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
    }

    @Transactional
    @Override
    public void updateComment(Comment comment, CommentUpdateRequestDto requestDto) {
        requestDto.updateComment(comment);
    }

    @Override
    public void isDeleted(Comment comment) {
        if (comment.isDeleted()) {
            throw new IllegalArgumentException("삭제된 댓글입니다.");
        }
    }

    @Transactional
    @Override
    public void deleteComment(Comment comment) {
        comment.delete();
    }

    @Override
    public List<Comment> getComments(UUID postId) {
        return commentRepository.findByPostId(postId);
    }

    @Transactional
    @Override
    public void deleteComments(List<Comment> comments) {
        for (Comment comment : comments) {
            comment.delete();
        }
    }
}

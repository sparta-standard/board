package io.sparta.board.application.usecase;

import io.sparta.board.model.entity.Comment;
import io.sparta.board.presentation.dto.request.CommentUpdateRequestDto;
import java.util.List;
import java.util.UUID;

public interface CommentService {

    Comment createComment(Comment comment);

    Comment getComment(UUID commentId);

    void updateComment(Comment comment, CommentUpdateRequestDto requestDto);

    void isDeleted(Comment comment);

    void deleteComment(Comment comment);

    List<Comment> getComments(UUID postId);

    void deleteComments(List<Comment> comments);
}

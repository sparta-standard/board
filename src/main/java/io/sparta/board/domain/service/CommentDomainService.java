package io.sparta.board.domain.service;

import io.sparta.board.application.dto.comment.CreateCommentRequestInternalDto;
import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentDomainService {

    private final CommentRepository commentRepository;

    public void createComment(Comment comment) {

        commentRepository.save(comment);
    }
}

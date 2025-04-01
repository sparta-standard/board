package io.sparta.board.domain.service;

import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentDomainService {

    private final CommentRepository commentRepository;

    public void createComment(Comment comment) {

        commentRepository.save(comment);
    }

    public Page<Comment> findAllByPost(Post post, Pageable pageable) {

        return commentRepository.findAllByPost(post, pageable);
    }
}

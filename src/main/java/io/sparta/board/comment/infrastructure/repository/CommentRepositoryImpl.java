package io.sparta.board.comment.infrastructure.repository;

import io.sparta.board.comment.domain.entity.Comment;
import io.sparta.board.comment.domain.repository.CommentRepository;
import io.sparta.board.post.domain.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final CommentJpaRepository commentJpaRepository;

    @Override
    public Comment save(Comment comment) {
        return commentJpaRepository.save(comment);
    }

    @Override
    public List<Comment> findByPost(Post post) {
        return commentJpaRepository.findByPost(post);
    }
}
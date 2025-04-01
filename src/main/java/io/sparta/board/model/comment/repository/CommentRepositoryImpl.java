package io.sparta.board.model.comment.repository;

import io.sparta.board.model.comment.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentReposiroy{

    private final CommentJpaRepository commentJpaRepository;

    @Override
    public Comment save(Comment comment) {
        return commentJpaRepository.save(comment);
    }

    @Override
    public Optional<Comment> findByIdAndDeletedIsFalse(UUID id) {
        return commentJpaRepository.findByIdAndDeletedIsFalse(id);
    }

    @Override
    public List<Comment> findByPostIdAndDeletedIsFalse(UUID id) {
        return commentJpaRepository.findByPostIdAndDeletedIsFalse(id);
    }
}

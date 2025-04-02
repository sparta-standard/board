package io.sparta.board.infrastructure.repository;

import io.sparta.board.domain.entity.Comment;
import io.sparta.board.domain.repository.CommentRepository;
import io.sparta.board.infrastructure.repository.jpa.CommentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final CommentJpaRepository commentJpaRepository;

    @Override
    public Comment save(Comment comment) {return commentJpaRepository.save(comment);}

    @Override
    public Comment findById(UUID id){return commentJpaRepository.findById(id).orElse(null);}
}

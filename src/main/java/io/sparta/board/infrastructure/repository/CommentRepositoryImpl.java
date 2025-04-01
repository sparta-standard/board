package io.sparta.board.infrastructure.repository;

import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final JpaCommentRepository jpaCommentRepository;

    @Override
    public void save(Comment comment) {

        jpaCommentRepository.save(comment);
    }
}

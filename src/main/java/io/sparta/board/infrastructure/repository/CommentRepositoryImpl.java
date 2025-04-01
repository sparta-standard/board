package io.sparta.board.infrastructure.repository;

import io.sparta.board.domain.model.Comment;
import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final JpaCommentRepository jpaCommentRepository;

    @Override
    public void save(Comment comment) {

        jpaCommentRepository.save(comment);
    }

    @Override
    public Page<Comment> findAllByPost(Post post, Pageable pageable) {

        return jpaCommentRepository.findAllByPost(post, pageable);
    }

    @Override
    public Optional<Comment> findById(UUID commentId) {

        return jpaCommentRepository.findById(commentId);
    }

    @Override
    public void deleteById(UUID commentId) {

        jpaCommentRepository.deleteById(commentId);
    }
}

package io.sparta.board.infrastructure;

import io.sparta.board.domain.Comment;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, UUID> {

}

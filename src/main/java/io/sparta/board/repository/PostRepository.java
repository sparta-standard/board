package io.sparta.board.repository;

// 게시글, 댓글,저장 / 조회/ 삭제가 가능한 Repository 만들기
// soft-delete 처리된 데이터는 제외하고 조회하기

import io.sparta.board.entity.Post;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, UUID>
{

  // 삭제되지 않은 게시글만 조회
  Optional<Post> findByIdAndDeletedFalse(UUID id);

  List<Post> findAllByDeletedFalse();
}

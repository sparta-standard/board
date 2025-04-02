package io.sparta.board.infrastructure.repository.jpa;

import io.sparta.board.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostJpaRepository extends JpaRepository<Post, UUID> {

}

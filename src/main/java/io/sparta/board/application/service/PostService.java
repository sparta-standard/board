package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.PostCreationRequestDto;
import io.sparta.board.application.dto.response.PostCreationResponseDto;
import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;

    public PostCreationResponseDto postCreate(PostCreationRequestDto dto) {
        Post post = dto.toEntity();
        // log.info("자바 어플리케이션에서 post.create {}, post.updated {}, post.uuid {}", post.getCreated_at(), post.getUpdated_at(), post.getId());
        // --> 모두 null 이 찍힘
        Post saved = postRepository.save(post);
        // @UuidGenerator, @CreationTimestamp, @UpdateTimestamp 어노테이션이 작성된 필드 모두 db 에서 값이 생성됨.
        // log.info("db 로부터 받은 엔터티 객체에서 post.create {}, post.updated {}, post.uuid {}", saved.getCreated_at(), saved.getUpdated_at(), saved.getId());
        return new PostCreationResponseDto(saved);
    }
}

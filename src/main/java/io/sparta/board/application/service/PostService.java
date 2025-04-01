package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.PostCreationRequestDto;
import io.sparta.board.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.application.dto.response.DeletePost;
import io.sparta.board.application.dto.response.PostCreationResponseDto;
import io.sparta.board.application.dto.response.PostUpdateResponseDto;
import io.sparta.board.application.dto.response.ShowPostOneResponseDto;
import io.sparta.board.domain.model.Post;
import io.sparta.board.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;

    public PostCreationResponseDto create(PostCreationRequestDto dto) {
        Post post = dto.toEntity();
        // log.info("자바 어플리케이션에서 post.create {}, post.updated {}, post.uuid {}", post.getCreated_at(), post.getUpdated_at(), post.getId());
        // --> 모두 null 이 찍힘
        Post saved = postRepository.save(post);
        // @UuidGenerator, @CreationTimestamp, @UpdateTimestamp 어노테이션이 작성된 필드 모두 db 에서 값이 생성됨.
        // log.info("db 로부터 받은 엔터티 객체에서 post.create {}, post.updated {}, post.uuid {}", saved.getCreated_at(), saved.getUpdated_at(), saved.getId());
        return new PostCreationResponseDto(saved);
    }

    @Transactional
    public PostUpdateResponseDto update(PostUpdateRequestDto dto, UUID id) {
        // 1. 수정하고자 하는 post 가 존재하는지 확인
        Post post = getPost(id);

        // 2. 요청 dto 가 null 이라면
        // *** controller 에서 예외처리할 것
        if(dto.getTitle() == null && dto.getContent() == null) {
            throw new IllegalArgumentException("제목 또는 내용에서 수정된 사항이 없습니다.\n 수정 사항을 다시 확인해주세요.");
        }

        log.info("수정 데이터 = {}", dto.toString());

        // 3. id 가 존재한다면 데이터에 저장되어있는 post 의 title 과 content 내용 비교 후
        // 다르다면 dto 의 데이터로 재설정
        if(dto.getTitle() != null && !post.getTitle().equals(dto.getTitle())) {
            post.setTitle(dto.getTitle());
        }

        log.info("디비에 저장된 내용: {}, 수정요청 내용: {}", post.getContent(), dto.getContent());


        if(dto.getContent() != null && !post.getContent().equals(dto.getContent())) {
            post.setContent(dto.getContent());
        }

        Post updatePost = postRepository.save(post);
        return new PostUpdateResponseDto(updatePost);
    }

    @Transactional
    public DeletePost delete(UUID id) {
        // 1. 수정하고자 하는 post 가 존재하는지 확인
        Post post = getPost(id);
        // 2. 존재한다면 deleted 의 값을 true 로 변경
        post.delete();
        // 3. 상태 값 업데이트
        Post delete = postRepository.save(post);
        return new DeletePost(delete);
    }

    // 수정, 조회, 삭제 메서드에서 작성해야하는 공통 코드이므로 메서드 추출함.
    private Post getPost(UUID id) {
        return postRepository.findById(id).orElseThrow(
                // 게시물이 존재하지 않을 때, 어떤 예외를 발생시켜야할지 모르겠음.
                // 상황에 따른 예외 클래스 사용법에 대한 기준을 모르겠음.
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다.")
        );
    }

    /*
        - 게시글에 포함된 모든 댓글 목록을 조회
        - 삭제된 데이터는 조회 불가능
     */
    public ShowPostOneResponseDto findOnePost(UUID id) {
        Post post = getPost(id);
        // 삭제된 데이터는 조회 불가능하게 처리
        if(post.isDeleted()) {
            throw new IllegalArgumentException("해당 게시물은 삭제되었습니다.");
        }

        return new ShowPostOneResponseDto(post);

    }
}

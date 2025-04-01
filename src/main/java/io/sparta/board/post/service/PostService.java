package io.sparta.board.post.service;


import io.sparta.board.comment.dto.responseDto.CommentResponseDto;
import io.sparta.board.comment.model.Comment;
import io.sparta.board.comment.repository.CommentRepository;
import io.sparta.board.common.PageRequestDto;
import io.sparta.board.post.dto.requestDto.PostRequestDto;
import io.sparta.board.post.dto.responseDto.PostCreateResponseDto;
import io.sparta.board.post.dto.responseDto.PostDeleteResponseDto;
import io.sparta.board.post.dto.responseDto.PostDetailsResponseDto;
import io.sparta.board.post.dto.responseDto.PostResponseDto;
import io.sparta.board.post.dto.responseDto.PostUpdateResponseDto;
import io.sparta.board.post.model.Post;
import io.sparta.board.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "PostService")
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    // 게시물 단일 조회
    @Transactional
    public PostDetailsResponseDto getPost(UUID postId, Integer page, Integer size) {
        log.info("get Post - postId : " + postId);

        Post post = postRepository.findByIdAndIsDeletedFalse(postId)
            .orElseThrow(() -> new EntityNotFoundException("Post not found"));

        Page<Comment> comments = commentRepository.findAllByPostIdAndIsDeletedFalse(
            postId, new PageRequestDto(page,size).getPageable());

        post.upCount();

        return new PostDetailsResponseDto(post, comments.map(CommentResponseDto::new));
    }

    // 게시물 전체 조회
    @Transactional(readOnly = true)
    public Page<PostResponseDto> getPosts(Integer page, Integer size) {
        log.info("get Posts pageable");

        Pageable pageable = new PageRequestDto(page, size).getPageable();

        return postRepository.findAllByIsDeletedFalse(pageable)
            .map(PostResponseDto::new);
    }

    // 게시물 생성
    @Transactional
    public PostCreateResponseDto createPost(PostRequestDto requestDto) {
        log.info("create Post - requestDto : " + requestDto);

        Post post = Post.builder()
            .title(requestDto.getTitle())
            .content(requestDto.getContent())
            .build();

        postRepository.save(post);
        return new PostCreateResponseDto(post);
    }

    // 게시물 수정
    @Transactional
    public PostUpdateResponseDto updatePost(UUID postId, PostRequestDto requestDto) {
        log.info("update Post - postId : " + postId);

        Post post = postRepository.findByIdAndIsDeletedFalse(postId)
            .orElseThrow(() -> new EntityNotFoundException("Post not found"));

        post.updatePost(requestDto.getTitle(), requestDto.getContent());

        return new PostUpdateResponseDto(post);
    }

    // 게시물 삭제 (soft delete + 댓글 삭제)
    @Transactional
    public PostDeleteResponseDto deletePost(UUID postId) {
        log.info("delete Post - postId : " + postId);

        Post post = postRepository.findByIdAndIsDeletedFalse(postId)
            .orElseThrow(() -> new EntityNotFoundException("Post not found"));

        post.delete();

        List<Comment> comments = commentRepository.findAllByPostId(postId);
        comments.forEach(Comment::delete);

        return new PostDeleteResponseDto(postId, "Post deleted successfully");
    }
}

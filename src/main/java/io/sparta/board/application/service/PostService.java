package io.sparta.board.application.service;

import io.sparta.board.application.dto.request.PostCreateRequestDto;
import io.sparta.board.application.dto.request.PostUpdateRequestDto;
import io.sparta.board.application.dto.response.CommentGetResponseDto;
import io.sparta.board.application.dto.response.PostGetResponseDto;
import io.sparta.board.application.mapper.CommentMapper;
import io.sparta.board.application.mapper.PostMapper;
import io.sparta.board.domain.entity.Comment;
import io.sparta.board.domain.entity.Post;
import io.sparta.board.domain.repository.CommentRepository;
import io.sparta.board.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostMapper postMapper;
    private final CommentMapper commentMapper;

    @Transactional
    public void createPost(PostCreateRequestDto dto) {
        Post post = postMapper.toEntity(dto);
        postRepository.save(post);
    }

    @Transactional
    public void updatePost(UUID id, PostUpdateRequestDto dto) {
        Post post = getPostById(id);
        post.updateOf(dto);
    }

    @Transactional
    public void deletePost(UUID id) {
        Post post = getPostById(id);
        post.deletedOf();

        List<Comment> commentList = commentRepository.findByPostIdAndDeletedIsFalse(id);
        for(Comment comment : commentList) {
            comment.deletedOf();
        }
    }

    @Transactional(readOnly = true)
    public PostGetResponseDto getPost(UUID id) {
        Post post = getPostById(id);

        List<Comment> commentList = commentRepository.findByPostIdAndDeletedIsFalse(id);
        List<CommentGetResponseDto> commentDtoList = new ArrayList<>();

        for(Comment comment : commentList) {
            commentDtoList.add(commentMapper.toDto(comment));
        }
        return postMapper.toDto(post, commentDtoList);
    }


    public Post getPostById(UUID id) {
        return postRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new RuntimeException("해당 게시물이 존재하지 않습니다."));
    }
}

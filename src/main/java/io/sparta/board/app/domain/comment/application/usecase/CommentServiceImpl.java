package io.sparta.board.app.domain.comment.application.usecase;

import io.sparta.board.app.domain.comment.model.entity.Comment;
import io.sparta.board.app.domain.comment.model.repository.CommentRepository;
import io.sparta.board.app.domain.comment.presentation.dto.request.CommentCreateRequestDto;
import io.sparta.board.app.domain.comment.presentation.dto.response.CommentCreateResponseDto;
import io.sparta.board.app.domain.comment.presentation.mapper.CommentMapper;
import io.sparta.board.app.domain.post.model.entity.Post;
import io.sparta.board.app.domain.post.model.repository.PostRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	@Transactional
	@Override
	public CommentCreateResponseDto createComment(CommentCreateRequestDto commentCreateRequestDto) {
		UUID postId = commentCreateRequestDto.getPostId();

		Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("post not found"));

		Comment newComment = CommentMapper.commentCreateRequestDtotoEntity(commentCreateRequestDto, post);
		Comment createdComment = commentRepository.save(newComment);
		return CommentMapper.entityToCreateResponseDto(createdComment);
	}
}

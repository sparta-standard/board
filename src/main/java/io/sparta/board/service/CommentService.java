package io.sparta.board.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.sparta.board.dto.CommentRequestDto;
import io.sparta.board.dto.CommentResponseDto;
import io.sparta.board.entity.Comment;
import io.sparta.board.entity.Post;
import io.sparta.board.repository.CommentRepository;
import io.sparta.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CommentService {

	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	@Transactional
	public CommentResponseDto createComment(UUID postId, CommentRequestDto requestDto) {
		//댓글을 남길 게시물 정보 찾기
		Post post = postRepository.findByPostIdAndDeletedFalse(postId).orElseThrow(
			() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + postId));

		Comment comment = Comment.createComment(post, requestDto);
		commentRepository.save(comment);

		return CommentResponseDto.from(comment.getCommentId(), postId, comment.getContent());
	}

	@Transactional
	public CommentResponseDto updateComment(UUID commentId, CommentRequestDto requestDto) {
		//수정할 댓글 정보
		Comment comment = commentRepository.findByCommentIdAndDeletedFalse(commentId)
			.orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

		comment.update(requestDto.getContent());
		commentRepository.save(comment);

		return CommentResponseDto.from(comment.getCommentId(), comment.getPost().getPostId(), comment.getContent());
	}

	@Transactional
	public CommentResponseDto deleteComment(UUID commentId) {
		//삭제할 댓글 정보
		Comment comment = commentRepository.findByCommentIdAndDeletedFalse(commentId)
			.orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

		comment.delete(true);
		commentRepository.save(comment);

		return CommentResponseDto.from(comment.getCommentId(), comment.getPost().getPostId(), comment.getContent());
	}
}

package io.sparta.board.app.domain.post.model.repository;

import static io.sparta.board.app.global.config.QueryDslConfig.getUsableSize;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.sparta.board.app.domain.post.model.entity.Post;
import io.sparta.board.app.global.config.QueryDslConfig;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import static io.sparta.board.app.domain.post.model.entity.QPost.post;

@RequiredArgsConstructor
@Repository
public class PostQueryRepository {

	private final JPAQueryFactory jpaQueryFactory;

	public Page<Post> findPostCommentList(UUID id, Pageable pageable) {

		OrderSpecifier<?>[] orderSpecifiers = QueryDslConfig.getAllOrderSpecifierArr(pageable, post);

		List<Post> contents = jpaQueryFactory
			.select(post)
			.from(post)
			.where(
				post.id.eq(id)
			)
			.orderBy(orderSpecifiers)
			.offset(pageable.getOffset())
			.limit(getUsableSize(pageable.getPageSize()))
			.fetch();

		JPAQuery<Long> countQuery = jpaQueryFactory
			.select(post.count())
			.from(post)
			.where(
				post.id.eq(id)
			);

		return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
	}
}

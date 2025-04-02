## TODO List

- [ ] responseDto, requestDto, Controller 생성
  - [x] post
  - [x] comment

- [ ] Entity 생성
  - [x] post
  - [x] comment


- [ ] 게시글 작성 API 구현
  - [x] 게시글 작성 서비스 구현
  - [x] 게시글 작성시 create_at, update_at - JPA Audit 사용
  - [x] deleted(false) 입력

- [ ] 게시글 수정 API 구현
  - [x] 게시글 수정 서비스 구현
  - [x] 수정시 해당 id 값 없는 경우
  - [x] 게시글 수정시 update_at 수정

- [ ] 게시글 삭제 API 구현
  - [x] 게시글 삭제 서비스 구현
  - [x] 삭제시 해당 id 값 없는 경우
  - [x] 삭제시 deleted true로 변경(soft delete)
  - [ ] 관련 댓글 같이 삭제

- [ ] 게시글 단건 조회 API 구현
  - [x] 게시글 단건 조회 서비스 구현
  - [x] 조회시 해당 id 값 없는 경우
  - [x] 조회시 deleted true 인 경우 조회 불가

- [ ] 댓글 등록 API 구현
  - [x] 댓글 등록 서비스 구현
  - [x] 댓글 등록시 create_at, update_at - JPA Audit 사용
  - [x] deleted(false) 입력
  - [x] 해당 게시글 없는 경우 댓글 등록 불가

- [ ] 댓글 수정 API 구현
  - [x] 댓글 수정 서비스 구현
  - [x] 댓글 수정시 해당 id 값 없는 경우
  - [x] 댓글 수정시 해당 게시글 없는 경우
  - [x] 댓글 수정시 update_at 수정

- [ ] 댓글 삭제 API 구현
  - [x] 댓글 삭제 서비스 구현
  - [x] 댓글 삭제시 해당 id 값 없는 경우
  - [x] 댓글 삭제시 deleted true로 변경(soft delete)


- [ ] 도전 과제
  - [ ] 게시글 조회 시 해당 게시글의 댓글 목록 페이징 처리



<br>

## 구현 시 어렵거나 이해가 되지 않는 부분
- JPA Audit 기능을 사용할 때 : @EntityListeners(AuditingEntityListener.class), @LastModifiedDate, @CreatedDate 이걸 설정하면 build 할 때 따로 값을 입력하지 않아도 된다고 본 것같은데, 자동으로 들어가지 않았다. 다른 추가 조건이나 설정이 필요한지 공부해야겠다. → ✅ 해결 : application 에 @EnableJpaAuditing 추가 안했었다.
- deleted에 false 값을 기본으로 입력하게 했는데 기본값으로 안들어 가져서, build시 false 입력을 해주었다. 기본값 설정 방법 추가 공부 필요하다.
- ⚠️ Failed to initialize JPA EntityManagerFactory: Property 'io.sparta.board.domain.entity.Comment.postId' is annotated @GeneratedValue but is not part of an identifier 오류 발생 → post_id 에 설정한@GeneratedValue(strategy = GenerationType.UUID) 에서 문제 → pk 아닌 필드에 해당 어노테이션 추가하여 문제 발생
- ❓댓글 삭제시 post_id 가 필요한가? 그냥 id 값만 받아서 삭제하는가? (post_id, id 값 둘 다 받아서 삭제하는 걸로 우선 구현)

<br>

## 추후 리팩토링
- 게시물 삭제시 관련 댓글 삭제
- 게시글 조회 시 해당 게시글의 댓글 목록 페이징 처리


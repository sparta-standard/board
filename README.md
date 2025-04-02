## TODO List
- [X] 패키지 구조 설계


- [X] BaseEntity 설계
  - [X] createdAt, updatedAt, deletedAt
  - [X] softDelete()


- [X] 게시글 Entity 설계
  - [X] postId, postTitle, postContent
- [X] 댓글 Entity 설계
  - [X] commentId, commentContent


- [X] 게시글 DTO, mapper 설계
- [X] 댓글 DTO, mapper 설계


- [X] 게시글 생성 API 구현
  - [X] 제목, 내용 필수 처리

- [X] 게시글 조회 API 구현
  - [X] soft delete 는 제외
  - [X] 전체 조회
  - [X] 단건 조회
  - [ ] search 조회

- [X] 게시글 수정 API 구현
  - [X] 현재 존재하는 게시글인지 확인
  - [X] 제목, 내용만 수정 가능

- [X] 게시글 삭제 API 구현
  - [X] 현재 존재하는 게시글인지 확인
  - [X] soft delete 처리

- [X] 게시글 예외 처리
  - [X] soft delete 처리되었는지 확인 후 "이미 삭제된 게시글입니다."
  - [ ] 아예 존재하지도 않았다면 "존재하지 않는 게시글입니다."

- [ ] 게시글 페이징 적용


- [X] 댓글 생성 API 구현
    - [X] 내용 필수 처리

- [X] 댓글 조회 API 구현
    - [X] soft delete 는 제외

- [X] 댓글 수정 API 구현
    - [X] 현재 존재하는 댓글인지 확인
    - [X] 내용만 수정 가능

- [X] 댓글 삭제 API 구현
    - [X] 현재 존재하는 댓글인지 확인
    - [X] soft delete 처리

- [X] 댓글 예외 처리
    - [X] soft delete 처리되었는지 확인 후 "이미 삭제된 댓글입니다."
    - [ ] 아예 존재하지도 않았다면 "존재하지 않는 댓글입니다."

- [ ] 댓글 페이징 적용

## 구현 시 어렵거나 이해가 되지 않는 부분
- 상황별 적절한 어노테이션 쓰임새를 헷갈린다. (특히 @AllArgsConstructor, @NoArgsConstructor)
- soft delete 시 엔티티에 조회되지 않도록 설정할 때 where 과 SQLRestriction 차이점이 뭔지 모르겠다.
- 계속 존재하는 게시글/댓글 인지 확인하는 코드가 중복되는데 한번에 처리할 수 있는 방법이 있는지 궁금하다.
- 메세지도 공통 처리가 가능한지 궁금하다.
- 적절한 상태코드를 모르겠다.
- 게시글 삭제할 때 해당 게시글의 댓글도 함께 삭제되는 코드를 모르겠다.
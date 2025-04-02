## TODO List
- [x] 게시글 작성 API 구현
  - [x] controller, dto, repository 생성
  - [x] 비즈니스 로직 구현
  - [x] 제목, 내용 not null
  - [x] 게시글 일자 자동 기록

- [x] 게시글 수정 API 구현
  - [x] controller, dto, repository 생성
  - [x] 비즈니스 로직 구현 (삭제된 게시글 예외처리)
  - [x] 제목과 내용만 수정 가능
  - [x] 게시글 수정 일자 자동 기록

- [x] 게시글 삭제 API 구현
  - [x] controller, dto, repository 생성
  - [ ] 삭제 시 게시글과 함께 해당 게시글의 모든 댓글도 삭제 처리
  - [x] 삭제 후 복구 불가능
  - [x] 게시글 삭제 시 삭제 상태에 대한 변경만 처리(soft-delete)

- [x] 게시글 단건 조회 API 구현
  - [x] controller, dto, repository 생성
  - [x] 비즈니스 로직 구현 (삭제된 게시글 예외처리)
  - [x] 게시글에 포함된 모든 댓글 목록 조회
  - [ ] 게시글에 댓글 목록 페이징 처리
  - [x] 삭제된 데이터는 조회 불가

- [x] 댓글 등록 API 구현
  - [x] controller, dto, repository 생성
  - [x] 비즈니스 로직 구현 
  - [x] 댓글 내용 not null
  - [x] 댓글 등록 일자 자동 기록

- [x] 댓글 수정 API 구현
  - [x] controller, dto, repository 생성
  - [x] 비즈니스 로직 구현 (삭제된 댓글 예외처리)
  - [x] 댓글 내용만 수정 가능
  - [x] 댓글 수정 일자 자동 기록

- [x] 댓글 삭제 API 구현
  - [x] controller, dto, repository 생성
  - [x] 비즈니스 로직 구현 (삭제된 댓글 예외처리)
  - [x] 삭제 후 복구 불가능
  - [x] 댓글 삭제 시 삭제 상태에 대한 변경만 처리(soft-delete)

## 추후 학습 & 이해가지 않는 부분
- [ ] 조회된 게시글에 댓글만 페이징 처리 학습 필요
- [ ] 게시글이 삭제 메서드에 댓글 삭제 로직 추가 필요
- [ ] QueryDsl 내부 동작 원리 이해 필요
## TODO List

- [ ] 게시글 등록 API 
  - [ ] Entity 작성
  
- [ ] 공통 처리
  - [ ] BaseEntity 작성
  - [ ] JpaAudit 작성

- [ ] 게시글 수정 API 구현
- [ ] 게시글 삭제 API 구현
- [ ] 게시글 단건 조희 API 구현
  - [ ] QueryDsl 작성

- [ ] 댓글 등록 API 구현
  - [ ] Entity 작성
- [ ] 댓글 수정 API 구현
- [ ] 댓글 삭제 API 구현

- [ ] 공통 처리
  - [ ] soft-delete 처리
  - [ ] valid 처리
  - [ ] exception 처리
...
  
---
## 도전 과제
- 게시글 조회 시 해당 게시글의 댓글 목록 페이징 처리
- Pagination 시 요청 Page Size가 10/30/50이 아닌 경우 10으로 고정하세요

## 추후 학습
- Jpa Audit 동작 원리
- QueryDsl 동작 원리
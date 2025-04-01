## TODO List

### 공통
- [X] JPA Audit 기능 설정
- [X] 데이터 변경 시점에 대한 추적/감사를 위한 메타 데이터 필드 구성

### 게시글
- [X] 게시글 작성 API 구현
    - [X] 게시글 작성 서비스 구현
- [ ] 게시글 수정 API 구현
    - [ ] 게시글 수정 시 예외 케이스 구현
       - [ ] 존재하지 않는 게시글 수정 시 예외 처리
       - [ ] 삭제된 게시글 수정 시 예외 처리
    - [X] 게시글 수정 서비스 구현
- [ ] 게시글 삭제 API 구현
    - [ ] 게시글 삭제 시 예외 케이스 구현
        - [ ] 게시글이 이미 삭제된 경우 예외 처리
        - [ ] 존재하지 않는 게시글 삭제 요청 시 예외 처리
    - [ ] 게시글 삭제 서비스 구현
- [ ] 게시글 단건 조회 API 구현
    - [ ] 게시글 삭제 시 예외 케이스 구현
        - [ ] 게시글이 이미 삭제된 경우 예외 처리
        - [ ] 존재하지 않는 게시글 삭제 요청 시 예외 처리
    - [ ] 게시글 단건 조회 서비스 구현
        - [ ] 댓글 목록까지 조회

### 댓글
- [ ] 댓글 작성 API 구현
    - [ ] 존재하지 않는 게시글에 댓글 작성 시 예외 처리
- [ ] 댓글 수정 API 구현
    - [ ] 존재하지 않는 댓글 수정 시 예외 처리
    - [ ] 삭제된 댓글 수정 시 예외 처리
- [ ] 댓글 삭제 API 구현
    - [ ] 삭제된 댓글 재삭제 요청 시 예외 처리
    - [ ] 존재하지 않는 댓글 삭제 시 예외 처리


...
---

## 구현 시 어렵거나 이해가 되지 않는 부분
- .
- 
# TODO List

## 게시글 ##
- [x] 게시글 생성 API 구현
    - [x] 게시글 작성 일자 자동기록


- [x] 게시글 수정 API 구현
    - [x] 게시글 수정 일자 자동기록


- [x] 게시글 단건 조회 API 구현
    - [x] 게시글에 포함된 모든 댓글 목록을 조회
    - [x] 게시글에 포함된 댓글 조회시 페이지네이션 처리


- [x] 게시글 삭제 API 구현
    - [x] 게시글 삭제 시 예외 케이스 구현
        - [x] 게시글이 이미 삭제된 경우 예외 처리
        - [x] 존재하지 않는 게시글 삭제 요청 시 예외 처리
    - [x] 게시글 삭제시 연관 댓글 삭제 처리

## 댓글 ##
- [x] 댓글 생성 API 구현
    - [x] 댓글 등록 일자 자동기록


- [x] 댓글 수정 API 구현
    - [x] 댓글 수정 일자 자동기록


- [x] 댓글 조회 API 구현
  - [x] 댓글 조회시 페이지네이션 처리


- [x] 댓글 삭제 API 구현
    - [x] 댓글 삭제시 변경 불가능
    - [x] 댓글 삭제시 삭제 상태에 대한 변경만 처리(soft-delete)

## 구현시 어렵거나 이해가 되지 않는 부분
- JPA의 내부 동작 원리를 알지 못합니다.
- 기본 트랜잭션 전파 전략인 REQUIRED만 사용합니다.
- 엔티티가 영속성 컨텍스트에 등록되는 타이밍을 정확히 알지 못하여 save() 메서드를 중복으로 사용합니다.
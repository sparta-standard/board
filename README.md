## TODO List

### 프로젝트 초기 설정
- [x] Spring Boot 프로젝트 생성
- [x] 의존성 추가
- [x] application.yml 설정

### Entity 설계
- [x] 게시글(Post) 엔티티 설계
- [x] 댓글(Comment) 엔티티 설계
- [x] JPA Auditing 설정

### Repository 생성
- [x] PostRepository 생성
- [x] CommentRepository 생성

### DTO 설계
- [x] 게시글 등록 요청 DTO (PostCreateRequestDto)
- [x] 게시글 응답 DTO (PostResponseDto)
- [x] 게시글 수정 요청 DTO (PostUpdateRequestDto)

- [x] 댓글 등록 요청 DTO (CommentCreateRequestDto)
- [x] 댓글 응답 DTO (CommentResponseDto)
- [x] 댓글 수정 요청 DTO (CommentUpdateRequestDto)

### Service 로직
- [x] 게시글 등록 기능 구현
- [x] 게시글 전체 조회 기능 구현
- [x] 게시글 개별 조회 기능 구현
- [x] 게시글 수정 기능 구현
- [x] 게시글 삭제 기능 구현

- [x] 댓글 등록 기능 구현
- [x] 댓글 수정 기능 구현
- [x] 댓글 삭제 기능 구현

### Controller(API) 구현
- [x] 게시글 API 구현
- [x] 댓글 API 구현

### 도전과제 
- [ ] 게시글 조회 시 해당 게시글의 댓글 목록 페이징 처리
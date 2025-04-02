# 📝board project

## 🥅목표 
1. Spring Boot + JPA를 이용해서 게시판 CRUD를 구현하면서 기본적인 Web Application을 구현
2. Spring Boot 기술 기본기 다지기

## ☑️To Do List (Basic)
1. 게시글 CRUD 작성
   - 게시글 작성 : 제목, 내용 v
   - 게시글 수정 : 제목, 내용 v
   - 게시글 삭제 : soft-delete 방식 v
   - 게시글 조회 : 단건 조회 -> 삭제된 데이터는 조회 불가능 v
2. 댓글 comment 작성
   - 댓글 작성 : 내용 v
   - 댓글 수정 : 내용 v
   - 댓글 삭제 : soft-delete 방식 / 복구 불가능 v

## ☑️To Do List (Challenge)
Pagination 요청 Page Size가 10/30/50이 아닌경우 10으로 고정

## 🏗️ 프로젝트 구조
간단한 프로젝트이기 때문에 3계층 구조로 설게하였음

├── Controller

│ ├── dto # 응답/요청 DTO 클래스

│ └── controller # API 요청 처리

├── Service

│ └── service # 핵심 비즈니스 로직 처리

├── Repository

│ ├── entity # 엔티티

│ └── repository# JPA, QueryDSL 등의 구현체

## 🔖참고사항
- JPA 의 MANY TO ONE , OEN TO MANY 에 대해 이해도가 부족한 상황(양방향으로 연결하여 데이터를 지속적으로 참조하여 무한으로 데이터를 참조하는 현상을 확인)으로 판단. 추후 자세히 공부의 필요성을 느낌
- 페이징 기법을 어렴풋이 알고 있는 듯한 느낌을 받음, JPA의 추가 기능이므로 숙지가 필요하다고 느낌
- Response Entity를 사용하여 response를 반환하게 확장 가능하나, 당장은 기능이 필요하다고 느껴지지 않아 string 데이만 보냄 -> 필요하다면 responseDto를 생성하여 ResponseEntity 매핑가능.
- 동일한 형태의 dto가 다수 존재하지만, 추후 확장성을 고려하여 분리하였음.



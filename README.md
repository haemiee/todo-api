# Todo API

개인 일정 관리 REST API 프로젝트입니다.

Java/Spring Boot 개발 감각을 되살리고,
REST API, JPA, Validation, 예외 처리 및 테스트를 다시 학습하기 위한 미니 프로젝트입니다.

## 📌 프로젝트 정보

- 개발 기간: 2026.09
- 개발 인원: 1명
- 개발 목적: Java/Spring Boot 개발 감각 회복

## 🛠 기술 스택

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Gradle
- JUnit 5
- Mockito
- STS

## 📋 주요 기능

- [x] 일정 등록
- [x] 일정 목록 조회
- [x] 일정 상세 조회
- [x] 일정 수정
- [x] 일정 삭제
- [x] 일정 완료/미완료 처리
- [x] 제목 키워드 검색
- [x] 페이징
- [x] Validation
- [x] 예외 처리
- [x] 단위 테스트

## 🔗 API

| Method | URL | 설명 |
|---|---|---|
| POST | `/api/tasks` | 일정 등록 |
| GET | `/api/tasks` | 일정 목록 조회 |
| GET | `/api/tasks/{id}` | 일정 상세 조회 |
| PUT | `/api/tasks/{id}` | 일정 수정 |
| DELETE | `/api/tasks/{id}` | 일정 삭제 |
| PATCH | `/api/tasks/{id}/complete` | 완료 상태 변경 |
| GET | `/api/tasks?keyword=Spring` | 제목 검색 |
| GET | `/api/tasks?page=0&size=5` | 페이징 |

## 🔍 Validation

일정 등록 및 수정 요청에 대한 입력값을 검증합니다.

- 제목 필수
- 마감일 필수

잘못된 요청은 `400 Bad Request`를 반환합니다.

## ⚠️ Exception Handling

존재하지 않는 일정을 조회, 수정 또는 삭제하는 경우

`404 Not Found`를 반환합니다.

## 🧪 Test

JUnit 5와 Mockito를 사용하여 Entity 및 Service 로직을 테스트했습니다.

주요 테스트:

- 일정 생성 시 기본 완료 상태 검증
- 완료 상태 변경 검증
- 일정 수정 검증
- 일정 조회 검증
- 존재하지 않는 일정 예외 검증
- 일정 삭제 검증

## 💡 개발하면서 배운 점

- Spring Data JPA를 이용한 CRUD 구현
- JPA Dirty Checking을 이용한 Entity 수정
- `@Transactional`의 역할
- `@Valid`를 이용한 요청 데이터 검증
- `@RestControllerAdvice`를 이용한 전역 예외 처리
- Spring Data JPA Query Method를 이용한 검색
- `Pageable`과 `Page`를 이용한 페이징
- JUnit 5와 Mockito를 이용한 단위 테스트
## 성능테스트 샘플 프로젝트

- 기술스택 : springboot 3, java 17, spring-data-jpa, gradle, mysql이다.
- 프로젝트의 결제 API는 존재하는 유저의 amount값을 update하는 방식이다.
    - 만약 요청금액이 음수라면 결제 실패 응답을, 그외에는 성공 응답을 반환한다.
- bulk api로 대량의 유저정보를 저장한 후 조회 성능을 테스트한다.
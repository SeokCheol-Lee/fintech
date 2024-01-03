# 대출심사 서비스 만들기

은행 업무중 대출 심사를 진행하는 서비스 프로젝트

## 프로젝트 구성
![SCD](doc/img/SystemConfigurationDiagram.png)

## Sequence Diagram
![SequenceDiagram](doc/img/squenceDiagram.png)

- 대출 요청
  - 사용자로부터 대출요청을 받음
  - UUID를 사용하여 UserKey를 생성한 후에 DB에 저장
  - Kafka에 message send
  - Listen한 Consumer에서 Proxy인 Nginx로 요청 전송
  - Nginx에서 CB사 역할을 하는 Css에 요청 전송
  - CB사에서 받은 정보를 DB에 저장
  

- 대출 확인
  - 사용자로부터 대출확인 요청을 UserKey로 받음
  - Redis Cache를 사용하여 캐시 추가 및 캐시 데이터 반환

## ERD
![ERD](doc/img/erd.png)

## 개선사항
- RestTemplate 대신 WebClient로 구현
- 외부와 통신하는 부분을 모듈화
- 도커 네트워크의 분리
- 실제 클라우드에 배포를 해보기
- 예외 처리 및 로그 적용하기
- 테스트 코드 전체적으로 구현해보기

### Tech Stack
<div align=center> 
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
  <img src="https://img.shields.io/badge/spring boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
  <img src="https://img.shields.io/badge/mysql-003545?style=for-the-badge&logo=mysql&logoColor=white"> 
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white"/>
  <img src="https://img.shields.io/badge/REDIS-DC382D?style=for-the-badge&logo=Redis&logoColor=white"/>
  <img src="https://img.shields.io/badge/Kafka-231F20?style=for-the-badge&logo=Apache Kafka&logoColor=white"/>
  <img src="https://img.shields.io/badge/nginx-009639?style=for-the-badge&logo=NGINX&logoColor=white"/>
  <img src="https://img.shields.io/badge/swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white"/>
</div>
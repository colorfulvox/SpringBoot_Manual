[뒤로가기](../../README.md)<br>

# application.properties

application.properties 설정들을 정리한다.<br>
(개발하면서 설정들이 추가된다.)<br>

## JPA 설정

> spring.jpa.hibernate.ddl-auto=none // create, create-drop, update, none

JPA를 사용할때 DB의 테이블 생성, 수정, 삭제등의 관리를 제어한다.

create : Entity를 기반으로 DB의 테이블을 생성한다. (이미 존재하면 삭제하고 다시 생성한다.)

create-drop : create와 유사하지만 서비스가 종료되면 테이블을 삭제한다.

update : Entity와 테이블을 비교하여 변경 사항을 업데이트한다. (기존 데이터는 유지된다.)

none : 어떤 작업도 수행하지 않는다.

> spring.jpa.generate-ddl=false // true

서비스 시작시 테이블을 초기화할지 결정한다.

> spring.jpa.database=mariadb

JPA를 사용하는 데이터베이스를 입력한다

> spring.jpa.show-sql=false // true

JPA나 hibernate를 통해 CRUD를 실행하면 CRUD의 SQL 로깅을 보여줄지 여부

## MariaDB 설정

```
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://{DB_IP}:{Port}/{DB 이름}
spring.datasource.username={사용자 이름}
spring.datasource.password={암호}
```

예시)

```
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://127.0.0.1:3306/account
spring.datasource.username=root
spring.datasource.password=1q2w3e4r
```

### Spring URI 경로 매칭 전략

클라이언트의 요청 URI와 컨트롤러의 URI 패턴을 비교하여 어떤 컨트롤러 메서드를 실행할지
결정하는데 사용한다.<br>

Spring MVC에서는 AntPathMathcer와 PathPatternParser 전략을 사용한다.<br>

> spring.mvc.pathmatch.matching-strategy=ant_path_matcher // path_pattern_parser

하지만, SpringBoot 2.6 버전 이후부터는 기본 전략이 path_pattern_parser으로 바뀌었다.<br>
그래서 추가한 몇몇 라이브러리에 오류가 발생할 수 있다.<br>

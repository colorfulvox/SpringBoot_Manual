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

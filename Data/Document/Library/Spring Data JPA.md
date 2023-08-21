[뒤로가기](../../../README.md)<br>

# Spring Data JPA

SpringBoot에서 JPA를 쓰기 편하게 만든 라이브러리

## Dependency

> implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

### JPA

Java의 ORM을 위한 표준 기술로 Hibernate, Spring JPA 등과 같은 구현체를 제공하는
표준 인터페이스이다.<br>

ORM : Java 객체와 관계형 DB를 맵핑하는 기술로 DB에 생성한 테이블과 Java의 객체가 맵핑되어<br>
일일이 SQL문으로 DB관리할 필요없이 객체로 관리할 수 있다.<br>

### JPA 적용

User Entity

```
@Table(name = "user")
public class User {
    @Id
    String userid;

    String userpassword;

    String username;

    Integer userage;
}
```

Repository

```
public interface UserRepository extends JpaRepository<User, String>{
}
```

다음과 같이 Spring Data JPA는 repository interfaces를 제공한다.<br>
(1) CrudRepository<br>
(2) PagingAndSortingRepository<br>
(3) JpaRepository<br>

JpaRepository를 인터페이스로 상속받아 원하는 방식으로 관리할 수 있다.<br>
여기서 JpaRepository<T, ID><br>
T는 관리할 도메인 클래스(Entity)<br>
ID는 도메인 클래스내의 필드에서 ID값의 타입 인자이다.<br>

### JPA 기능

# 이 부분은 프로젝트 예시로 설명해야겠다.

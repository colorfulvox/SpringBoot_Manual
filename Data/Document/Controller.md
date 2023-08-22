[뒤로가기](../../README.md)<br>

# Controller

### 프로젝트 예시는 SpringBoot_Repository/training 프로젝트이다.

## 프로젝트 환경

1. [Visual Studio Code](https://code.visualstudio.com/)
2. VSCode Extension
   - Java Extension Pack
   - Spring Boot Extension Pack
3. JDK : [Red Hat OpenJDK 17.0.6.0](https://developers.redhat.com/products/openjdk/download#assembly-field-downloads-page-content-82031)
4. SpringBoot
   - Version : 2.7.14
   - Build : Gradle
   - Library : Spring Web, SpringBoot DevTools, LomBok, Spring Data JPA, MariaDB Driver, Swagger=3.0.0
   - DataBase : MariaDB

## REST

자원을 이름으로 구분하고 해당 자원의 정보를 주고 받는 모든 행위를 의미한다.<br>
HTTP URI를 통해 자원을 명시하고 HTTP 메서드를 통해 자원을 요청받게 된다.<br>

HTTP 메서드

1. Create(POST) => 생성
2. Read(GET) => 조회
3. Write(PUT,PATCH) => PUT: 교체, PATCH: 업데이트
4. Delete(DELETE) => 삭제

즉,<br>
URI : 모든 자원에 대한 고유 ID<br>
HTTP 메서드 : 자원 처리에 대한 행위<br>
를 의미하며<br>
자원은 JSON, XML, TEXT, RSS등의 형태로 표현하게 된다.<br>
(주로 JSON, XML로 데이터를 전달한다.)<br>

## REST API

REST의 원리를 따르는 API를 뜻한다.<br>
REST API를 올바르게 설계하기 위해서는 몇가지 규칙이 있다.<br>

1. URI는 동사보다는 명사를, 대문자보다는 소문자를 사용한다.

> http://test.com/Working => X<br> > http://test.com/work => O

2. 마지막 슬래시를 포함하지 않는다.

> http://test.com/work/ => X<br> > http://test.com/work => O

3. 언더바 대신 하이폰을 사용한다.

> http://test.com/work_test => X<br> > http://test.com/work-test => O

4. 파일확장자는 URI에 포함하지 않는다.

> http://test.com/work.png => X<br> > http://test.com/work => O

5. 행위를 포함하지 않는다.

> http://test.com/create-work => X<br> > http://test.com/work => O

## RESTFUL

결국 REST API의 설계 원칙을 따른 시스템을 RESTful하다고 한다.

## Controller 어노테이션

Controller는 MVC패턴의 C의 역할이며 사용자의 요청을 받아 서비스에게 전달하는 역할을한다.<br>
그래서 해당 REST 원칙을 위한 HTTP 메서드에대한 어노테이션을 제공한다.

### @Controller

### @RestController

---

### @RequestMapping

### @GetMapping

### @PostMapping

### @PutMapping

### @PatchMapping

### @DeleteMapping

---

### @PathVariable

### @RequestParam

### @RequestBody

### @ResponseBody

### @RequestHeader

### @ModelAttribute

### @Valid

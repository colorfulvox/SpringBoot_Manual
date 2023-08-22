[뒤로가기](../../README.md)<br>

# Bean

Spring 컨테이너가 관리하는 자바 객체를 Bean이라 한다.

## 제어의 역전(IoC)

IoC는 객체의 생성 및 제어권을 사용자가 아닌 Spring에게
맡기는 것이다.<br>
평소 객체 지향 프로그래밍을 하면서 new연산을 통해 객체를 생성하고
메소드를 호출했지만,<br>
IoC가 적용된 Spring에서는 객체의 생성, 소멸 및 제어권을 Spring에게 넘긴다.<br>
그래서 사용자는 new를 이용해 생성한 객체를 사용하지 않고<br>
Spring이 자동으로 관리하는 자바 객체 즉, Bean을 사용한다.<br>

## 어노테이션

사전적 의미로는 주석이다.<br>
그래서 자바에서는 코드 사이의 주석처럼 쓰이며 특별한 의미, 기능을 수행하는 메타 데이터이다.<br>
그래서 클래스와 메서드에 어노테이션을 붙이면 다양한 기능을 부여할 수 있다.<br>

## Bean 등록 방법

### @Component

생성한 Class를 Spring 컨테이너에 Bean으로 등록할때 사용한다.

```
@Component
public class testBean{

    public testBean() {
        System.out.println("Test Bean");
    }

}
```

### @Component Scan

Component Scan은 @Component을 명시하며 Bean에 추가하는 방법이다.<br>
Class에 어노테이션을 추가하면 자동으로 Bean에 객체로 추가된다.<br>
대표적으로
@Component, @Service, @Repository, @Controller, @Configuration 어노테이션이 있다.<br>

### [의존 관계] @Autowired

DI는 클래스간의 의존 관계를 Spring 컨테이너가 자동으로 연결해주는것을 의미한다.<br>
그리고 Autowired를 통해 의존성 주입이 가능하다.<br>

(1) 필드 주입

```
@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
```

(2) 생성자 주입

```
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
```

(3) Setter 주입

```
@RestController
public class UserController {

    private final UserService userService;

    public UserController(){}

    @Autowired
    public setUserService(UserService userService){
        this.userService = userService;
    }
```

단, Setter 주입은 반드시 기본 생성자가 있어야한다.

이렇게, Autowired를 통해 UserController에 UserService에대한 의존성 주입을 하게된다.<br>
그래서,<br>

```
@Service
@Transactional
public class UserServiceImpl implements UserService {

    UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }
```

해당 UserService도 @Service 어노테이션을 통해 Bean에 등록되어야한다.<br>
(UserDAO도 마찬가지)<br>

참고로,<br>
Lombok의 @RequiredArgsConstructor를 사용하게되면
@Autowired와 생성자를 작성할 필요가 없다.<br>

```
@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    UserDAO userDAO; //이대로 선언만 해도 사용가능하다.
```

---

결론적으로<br>
UserController => UserService => UserRepository<br>
순서로 서비스가 운영되면서 각 단계에서 다음 단계의 Bean을 사용하기 위해
의존성 주입을 하게된다.<br>

### @Configuration, @Bean

Spring에서 Bean을 수동으로 등록할때 사용한다.<br>
(보통 외부 라이브러리를 사용할때 쓰인다.)<br>

(1) 출력 객체 생성

```
public class TestPrint {

    public Print(){
        System.out.println("Print Test");
    }
}
```

(2) testConfig에 Bean으로 등록

```
@Configuration
public class testConfig{

    @Bean
    public TestPrint testPrint()
    {
        return new TestPrint;
    }

}
```

(3) 등록한 Bean 사용

```
@Service
public class TestService{

    private final TestPrint testprint;

    @Autowired
    public TestService(TestPrint testprint){
        this.testprint = testprint;
    }

    public void printtest()
    {
        testprint.Print();
    }

}

```

@Configuration의 역할

1. Bean을 등록할때 싱글톤이 되도록 보장한다.
2. Spring 컨테이너에서 Bean을 관리할 수 있게 해준다.

결론적으로 @Bean만 사용해도 Spring 컨테이너에 Bean으로 등록은 되지만
싱글톤이 유지되지 않는다.

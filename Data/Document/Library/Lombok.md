[뒤로가기](../../../README.md)<br>

# Lombok

Java의 데이터 모델을 더 간결하고 효율적으로 관리할 수 있는 라이브러리이다.

## Dependency

> compileOnly 'org.projectlombok:lombok'<br>
> annotationProcessor 'org.projectlombok:lombok'

예를 들어

```
class User{
    private String id;
    private String password;
    private String name;
    private int age;

    public void setId(String id)
    {this.id = id;}

    public void getId()
    {return this.id;}

    .....

    public int getAge()
    {return this.age;}
}
```

이처럼 각 private 변수에 대한 Get, Set 메소드를 직접 작성해 User 데이터에 접근해야한다.<br>
하지만 Lombok을 사용하면,<br>

```
@Getter
@Setter
class User{
    private String id;
    private String password;
    private String name;
    private int age;

}
```

@Getter, @Setter 어노테이션 작성만으로 모든 User 클래스내의 변수들의 Get, Set 메소드를
추가해주게된다.<br>

## 주요 기능

### @Getter / @Setter

Getter, Setter 메서드를 자동으로 생성한다.

### @ToString

클래스내의 모든 변수값을 자동으로 문자열로 변환해 출력해준다.

> System.out.println(user); <br>
> // User(id=test, password=1q2w3e4r, name=chu, age=22)<br>

### @NoArgsConstructor

파라미터가 없는 기본 생성자를 생성해준다.

> User user = new User();

### @AllArgsConstructor

모든 필드값을 파라미터로 받는 생성자를 생성해준다.

> User user = new User("chu", "1q2w3e4r", "chu", 22);

### @RequiredArgsConstructor

final or @NonNull인 필드 값만 파라미터로 받는 생성자를 생성해준다.

```
@RequiredArgsConstructor
class User{
    final String id;

    private String password;
    private String name;

    @NonNull
    private int age;

}
```

> User user = new User("chu", 22);

### @EqualsAndHashCode

equals(), hashCode() 메서드를 자동으로 생성한다.<br>
필드의 값에 기반해 두 객체를 비교하게 된다.<br>

> user1.equals(user2) // true

만약 @EqualsAndHashCode가 없으면 객체의 내용이 같더라도 주소가 다르기 때문에
false를 반환한다.<br>

### @Data

@Getter / @Setter, @ToString, @RequiredArgsConstructor, @EqualsAndHashCode
를 한번에 설정해주는 어노테이션이다.

### @Builder

객체를 생성할때 보통 생성자를 쓰지만,<br>
@Builder를 활용하여 빌터 패턴으로 객체를 생성한다.<br>

예시)

```
@Builder
public class UserDto {

    private String userid;
    private String userpassword;
    private String username;
    private int userage;

    public User toEntity()
    {
        return User.builder()
        .userid(userid)
        .userpassword(userpassword)
        .username(username)
        .userage(userage)
        .build();
    }
}
```

여기서는 User Entity에 대한 객체를 빌더 패턴을 활용하여 생성한다.<br>
(UserDto의 필드 값으로 객체의 필드를 채우고 있다.)<br>

생성자가 있는데 굳이 쓰는 이유)

(1) 생성자로 생성시 파라미터 식별이 힘드며 값이 늘어날 수록 가독성이 떨어진다.<br>
하지만, 빌더 패턴은 각 필드 이름을 명시하며 진행되므로 쉽게 이해할 수 있다.<br>

(2) 생성자와 달리 값의 순서를 신경쓸 필요없다.<br>
생성자는 정해진 순서대로 파라미터값을 붙여야하지만 빌더 패턴에서는 필드 이름이 명시되므로
순서가 상관없다.<br>

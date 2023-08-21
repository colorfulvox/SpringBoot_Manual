[뒤로가기](../../../README.md)<br>

# SpringBoot DevTools

SpringBoot를 사용할때 좀 더 편리한 도구 세트를 제공하는 라이브러리이다.

## Dependency

> developmentOnly 'org.springframework.boot:spring-boot-devtools'

### Property Defaults

SpringBoot는 캐시를 사용하여 성능을 향상시킨다.<br>
예를 들어 템플릿 엔진은 템플릿 파일을 반복적으로 분석하지않고 컴파일된 템플릿을 캐시해 사용한다.<br>
하지만 캐싱은 서비스 중에는 유용하지만 개발 중에는 방금 변경된 내용을 볼 수 없는 단점이 있다.<br>
그래서 Property Defaults기능을 통해 개발시에 일반적인 설정값을 자동으로 설정해준다.<br>
또한, Property Defaults기능으로 개발 환경에서 속성 값을 편리하게 관리할 수 있다.<br>

### Automatic Restart

Spring Boot 앱을 개발하면서 서비스를 재시작해야하는 경우가 많다.<br>
클래스 하나만 수정해도 다시 시작해야되는 번거로움이 있다.<br>
그래서 Automatic Restart 기능으로 파일이 수정되면 자동으로 저장하고<br>
(ClassPath에 존재하는 파일의 변경을 감지) 자동으로 서버를 재시작해준다.<br>

### Live Reload

리소스가 변경되었을 경우 브라우저의 새로고침을 자동으로 해준다.<br>
Automatic Restart가 활성화 되어있을 경우 이용할 수 있다.<br>

### Remote Applications

원격 서버에 배포된 앱에 대해서도 DevTools를 활용할 수 있게 해준다.

### Global Settings

프로젝트의 전역 설정을 관리한다.<br>
Global Settings은 개발 환경에 적용된 application.properties 설정을 그대로<br>
실제 서비스 중에도 적용되는 문제를 막을 수 있다.<br>
예를 들어, src/main/resources/META-INF 경로에 spring-devtools.properties파일을<br>
생성하고 해당 파일에서 설정하면 개발 환경에서만 해당 설정이 적용된다.<br>
실제 서비스 중에도 해당 환경은 무시되어 개발, 서비스 간의 환경 설정 분리가 가능하다.<br>

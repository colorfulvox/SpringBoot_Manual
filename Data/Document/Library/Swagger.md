[뒤로가기](../../../README.md)<br>

# Swagger

Rest API의 설계, 개발, 테스트를 하는데 도움이 되는 Tool이다.<br>
(Postman대신 이걸 쓰면 된다!)<br>

## Dependency

> implementation group: 'io.springfox', name: 'springfox-boot-starter', version: '3.0.0'<br>
> implementation group: 'io.springfox', name: 'springfox-swagger-ui', version: '3.0.0'<br>

### [주의사항]

SpringBoot 2.6버전 이후 spring.mvc.pathmatch.matching-strategy의 기본값이<br>
ant_path_matcher에서 path_pattern_parser로 변경되었다.<br>
그래서 몇몇 라이브러리에 오류가 발생할 수 있는데 Swagger에서 오류가 발생한다.<br>

application.properties에서<br>

> spring.mvc.pathmatch.matching-strategy=ant_path_matcher

를 추가한다.<br>

## [사용법] - Swagger 3.0 기준

Docket은 Swagger 설정의 핵심이 되는 문서화 객체이다.<br>
그래서 Docket을 Bean에 등록해 Swagger을 활성화 시켜야한다.<br>

### [SwaggerConfig.java]

```
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
    }

    public ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
        .title("SpringBoot REST API")
        .version("1.0.0")
        .description("REST API")
        .build();
    }

}
```

api() 매서드는 Swagger를 설정하는 Docket을 생성한다.<br>

DocumentationType.OAS_30 : OAS는 RESTful API의 설계, 문서화 및 구현하기 위한
표준 규격이다.<br>

apiInfo() : API 문서의 기본 정보를 설정하는데 사용한다.<br>
그래서 apiInfo() 메서드에 타이틀명, 버전, 설명 등을 작성할 수 있다.<br>

select() : ApiSelectorBuilder를 생성한다.<br>
(Swagger에서 보여줄 endpoint를 제어할 방법을 제공한다. -> apis)<br>

apis() : 어떤 API를 가져올지 정한다.<br>
RequestHandlerSelectors.any()는 패키지의 모든 컨트롤러를 선택하도록 설정한다.<br>
RequestHandlerSelectors.basePackage("com.example.demo.api")<br>
만약 특정 패키지의 컨트롤러 기준으로만 만들고 싶으면 이렇게 basePackage로 지정한다.<br>

paths() : apis로 선택된 API중 특정 path 조건에 맞는 API들을 필터링하여 문서화한다.<br>
PathSelectors.any()는 모든 URL 패스를 선택하도록 설정한다.<br>

설정을 마치면, 프로젝트를 실행한뒤<br>

> http://localhost:8080/swagger-ui/index.html

해당 URL을 통해 Swagger에 접속한다.<br>

![img](../../Image/springboot26.png)<br>
접속하게되면 이렇게 컨트롤러에 생성한 API들을 보여주며 Try it out을 클릭해<br>
직접 값을 대입해 실행하면서 테스트를 할 수 있다.<br>

package springStudy.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//기존 예제 코드를 살리기 위해 필터를 통해 @Configuration 붙은 설정 파일은 스프링 빈으로 등록하지 않는다.
@ComponentScan(
        basePackages = "springStudy.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter
                (type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}

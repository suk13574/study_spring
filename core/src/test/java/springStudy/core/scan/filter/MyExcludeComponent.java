package springStudy.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//이 어노테이션이 붙으면 컴포넌트 스캔 대상에서 제외
public @interface MyExcludeComponent {

}

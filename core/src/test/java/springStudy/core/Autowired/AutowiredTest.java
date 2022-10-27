package springStudy.core.Autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import springStudy.core.member.Member;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){

        //TestBean -> 컴포넌트 스캔처럼 스프링 빈 등록된다.
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    /**
     * 테스트를 위한 임의의 클래스
     */
    static class TestBean {

        @Autowired(required = false)
        public void SetNoBean(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}

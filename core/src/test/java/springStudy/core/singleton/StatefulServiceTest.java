package springStudy.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userA = statefulService1.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문
        int userB = statefulService2.order("userB", 20000);

        //ThreadA: 주문 금액 조회
        System.out.println("price = " + userA);

//        assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }


    /**
     * 테스트를 위한 설정 파일
     */
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
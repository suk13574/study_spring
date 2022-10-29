package springStudy.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        //close 제공하는 인터페이스 사용
        ConfigurableApplicationContext ac
                = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        ac.getBean(NetworkClient.class);

        ac.close();
    }

    /**
     * 테스트를 위한 설정 클래스
     */
    static class LifeCycleConfig{
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}

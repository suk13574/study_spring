package springStudy.core.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springStudy.core.member.MemberService;
import springStudy.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class xmlAppContext {

    @Test
    void xmlAppContext(){
        ApplicationContext ac= new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
}

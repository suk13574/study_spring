package springStudy.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.member.Grade;
import springStudy.core.member.Member;
import springStudy.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {

        //AppConfig에서 구현체 결정
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링 컨테이너
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        //스프링 컨테이너에서 찾아오기 - (메서드)이름, 반환 타입
        MemberService memberService
                = applicationContext.getBean("memberService", MemberService.class);

        //회원 가입 테이스
        Member member1 = new Member(1L, "홍길동", Grade.VIP);
        memberService.join(member1); //회원가입

        //회원 가입 되었는지 테스트
        Member findMember = memberService.findMember(1L);
        System.out.println("newMember = " + member1.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}

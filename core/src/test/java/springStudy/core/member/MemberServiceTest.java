package springStudy.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springStudy.core.AppConfig;

public class MemberServiceTest {
    MemberService memberService;

    //테스트 실행 전 수행
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig= new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L, "member1", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}

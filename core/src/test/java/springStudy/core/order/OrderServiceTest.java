package springStudy.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springStudy.core.member.Grade;
import springStudy.core.member.Member;
import springStudy.core.member.MemberService;
import springStudy.core.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memebrA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId, "ItemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}

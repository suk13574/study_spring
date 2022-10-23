package springStudy.core;

import springStudy.core.discount.DiscountPolicy;
import springStudy.core.discount.FixDiscountPolicy;
import springStudy.core.discount.RateDiscountPolicy;
import springStudy.core.member.MemberService;
import springStudy.core.member.MemberServiceImpl;
import springStudy.core.member.MemoryMemberRepository;
import springStudy.core.order.OrderService;
import springStudy.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}

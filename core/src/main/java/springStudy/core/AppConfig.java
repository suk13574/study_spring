package springStudy.core;

import org.springframework.context.annotation.Bean;
import springStudy.core.discount.DiscountPolicy;
import springStudy.core.discount.FixDiscountPolicy;
import springStudy.core.discount.RateDiscountPolicy;
import springStudy.core.member.MemberService;
import springStudy.core.member.MemberServiceImpl;
import springStudy.core.member.MemoryMemberRepository;
import springStudy.core.order.OrderService;
import springStudy.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }


    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}

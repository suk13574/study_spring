package springStudy.core.order;

import springStudy.core.discount.DiscountPolicy;
import springStudy.core.discount.FixDiscountPolicy;
import springStudy.core.discount.RateDiscountPolicy;
import springStudy.core.member.Member;
import springStudy.core.member.MemberRepository;
import springStudy.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

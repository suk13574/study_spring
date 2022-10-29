package springStudy.core.Autowired;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.AutoAppConfig;
import springStudy.core.discount.DiscountPolicy;
import springStudy.core.member.Grade;
import springStudy.core.member.Member;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(
                AutoAppConfig.class, DiscountService.class
        );

        DiscountService discountService = ac.getBean(DiscountService.class);

        //discountPolicy 잘 받아졌는지 확인
        assertThat(discountService).isInstanceOf(DiscountService.class);

        //fixDiscount 확인
        Member member = new Member(1L, "UserA", Grade.VIP);
        int fixDiscountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
        assertThat(fixDiscountPrice).isEqualTo(1000);

        //rateDiscount 확인
        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
        assertThat(rateDiscountPrice).isEqualTo(2000);


    }


    /**
     * 테스트를 위한 클래스
     */
    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
        }


        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}

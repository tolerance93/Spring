package store.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import store.core.discount.DiscountPolicy;
import store.core.discount.FixDiscountPolicy;
import store.core.discount.RateDiscountPolicy;
import store.core.member.MemberRepository;
import store.core.member.MemberService;
import store.core.member.MemberServiceImpl;
import store.core.member.MemoryMemberRepository;
import store.core.order.OrderService;
import store.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    //spring container에 등록됨
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    // command + option + M: extract method
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 사용 영역의 코드는 손댈 필요 없이 구성 영역의 코드변경만하면 된다.
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

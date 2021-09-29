package store.core;

import store.core.discount.DiscountPolicy;
import store.core.discount.FixDiscountPolicy;
import store.core.discount.RateDiscountPolicy;
import store.core.member.MemberRepository;
import store.core.member.MemberService;
import store.core.member.MemberServiceImpl;
import store.core.member.MemoryMemberRepository;
import store.core.order.OrderService;
import store.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // command + option + M: extract method
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 사용 영역의 코드는 손댈 필요 없이 구성 영역의 코드변경만하면 된다.
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

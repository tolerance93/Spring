package store.core;

import store.core.discount.FixDiscountPolicy;
import store.core.member.MemberService;
import store.core.member.MemberServiceImpl;
import store.core.member.MemoryMemberRepository;
import store.core.order.OrderService;
import store.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}

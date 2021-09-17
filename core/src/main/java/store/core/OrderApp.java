package store.core;

import store.core.member.Grade;
import store.core.member.Member;
import store.core.member.MemberService;
import store.core.member.MemberServiceImpl;
import store.core.order.Order;
import store.core.order.OrderService;
import store.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}

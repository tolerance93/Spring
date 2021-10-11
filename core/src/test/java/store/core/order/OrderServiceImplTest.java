package store.core.order;

import org.junit.jupiter.api.Test;
import store.core.discount.FixDiscountPolicy;
import store.core.member.Grade;
import store.core.member.Member;
import store.core.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        // spring container에서 가져온게 아니라 순수 자바코드다. 생성자 주입을 해야 인자를 컴파일 타임에 에러검출 가능
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        orderService.createOrder(1L, "itemA", 10000);
    }

}
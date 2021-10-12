package store.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import store.core.annotation.MainDiscountPolicy;
import store.core.discount.DiscountPolicy;
import store.core.member.Member;
import store.core.member.MemberRepository;
import store.core.member.MemoryMemberRepository;

@Component
//@RequiredArgsConstructor //final keyword로 생성자 만들어줌
public class OrderServiceImpl implements OrderService {

    //생성자 주입시에 파이널 키워드를 추가할 수 있다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //setter 의존성 주입. 생성자가 먼저 불리고 그 다음에 세터로 의존성 주입
    //선택, 변경가능 의존성 주입시에 사
    //@Autowired(required = false) // 주입할 대상이 없어도 동작하게 하려면!
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    //생성자에는 왠만하면 값을 다 채워넣어야한다는 관례가 있음
    //생성자가 1개일때는 Autowired생략 가능
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //for test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

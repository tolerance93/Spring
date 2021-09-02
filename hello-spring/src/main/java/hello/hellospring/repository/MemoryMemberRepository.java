package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// 상황에따라 구현클래스가 변경될 수 있다면 config에 등록.
// 그게 아니라면 어노테이션으로 등록하자
// 기존의 코드를 하나도 손대지 않고 바꿔치기를 하는 방법임
public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 공유되는 변수일 경우 동시성 문제가 있을 수 있어, concurrent hashmap을 사용한다
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
       return  store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

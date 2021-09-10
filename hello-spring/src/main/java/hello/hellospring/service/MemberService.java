package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// command + shift + T: 테스트케이스 자동생성
@Transactional // jpa는 데이터변경이 transactional안에서 실행이 되어야 함
public class MemberService {

    private final MemberRepository memberRepository;

    // command + N: constructor 자동생
    // memberRepository를 외부에서 넣어줌. Dependency Injection션
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X
        // command + option + v: 리턴 자동완
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    // control + T: 리팩토링과 관련됨. 함수 추출
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

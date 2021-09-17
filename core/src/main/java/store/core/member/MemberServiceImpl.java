package store.core.member;

public class MemberServiceImpl implements MemberService {

    // command + shift + enter: 자동완성 + ;
    // 추상화에도 구체화에도 의존함. 문제!!!!! DIP 위반
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

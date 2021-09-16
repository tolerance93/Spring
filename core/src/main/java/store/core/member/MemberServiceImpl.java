package store.core.member;

public class MemberServiceImpl implements MemberService {

    // command + shift + enter: 자동완성 + ;
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

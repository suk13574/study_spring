package springStudy.core.member;

public class MemberServiceImpl implements MemberService{

    //MemberServiceImpl은 회원 저장소에 접근한다.
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

package springStudy.core.member;

public class MemberServiceImpl implements MemberService{

    //MemberServiceImpl은 회원 저장소에 접근한다.
    private final MemberRepository memberRepository;

    //생성자를 통해 MemberRepository의 구현체를 설정해준다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

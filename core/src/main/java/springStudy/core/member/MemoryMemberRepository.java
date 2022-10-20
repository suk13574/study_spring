package springStudy.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    //HashMap : 동시성 이슈가 있을 수 있다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member){
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

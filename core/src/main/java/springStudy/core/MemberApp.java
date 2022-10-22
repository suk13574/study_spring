package springStudy.core;

import springStudy.core.member.Grade;
import springStudy.core.member.Member;
import springStudy.core.member.MemberService;
import springStudy.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        //회원 가입 테이스
        MemberService memberService = new MemberServiceImpl();
        Member member1 = new Member(1L, "홍길동", Grade.VIP);
        memberService.join(member1); //회원가입

        //회원 가입 되었는지 테스트
        Member findMember = memberService.findMember(1L);
        System.out.println("newMember = " + member1.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}

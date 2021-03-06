package Hello.hellospring.service;

import Hello.hellospring.domain.Member;
import Hello.hellospring.repository.Memberrepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
public class MemberService {
    private final Memberrepository memberrepository; //
    public MemberService(Memberrepository memberrepository) {
        this.memberrepository = memberrepository; //외부에서 멤버리퍼지토리를 넣어준다 해당 하는걸 디펜던시 인젝션이라고 한다.
    }



    //회원 가입 부
    public Long join(Member member) {
        long start = System.currentTimeMillis();

        try{
            validateDuplicateMember(member); // 같은 이름이 있는 중복 회원 검증
            memberrepository.save(member);
            return member.getId(); // 회원 가입 후 아이디 반환
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }
        //같은 이름이 있는 중복 회원 검색부

    }

    private void validateDuplicateMember(Member member) {
        memberrepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    //전체 회원 조회
    public List<Member> findMembers(){

        long start = System.currentTimeMillis();
        try{
            return memberrepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers = " + timeMs + "ms");
        }

    }
    public Optional<Member> findOne(Long memberId) {
        return memberrepository.findById(memberId);
    }
}

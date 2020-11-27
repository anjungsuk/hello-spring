package Hello.hellospring.service;

import Hello.hellospring.domain.Member;
import Hello.hellospring.repository.Memberrepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest//spring test시에는 해당 어노테이션 사용
@Transactional//테스트 실행시 트랜잭션 실행 테스트가 끝나면 롤백 된다.
class MemberServiceintegrationTest {

    @Autowired MemberService memberService;
    @Autowired Memberrepository memberRepository;

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("kangjungu100"); // 회원가입시 DB에 넘어가는 이름명
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring"); // DB내 저장된 이름름
        //when
       memberService.join(member1);//회원 입력값 저장 부부
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//해당 로직 실행시 중복값 익셉션 처리
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123123");
//        }
        //then
    }
}
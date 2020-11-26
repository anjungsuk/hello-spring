package Hello.hellospring.service;

import Hello.hellospring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import Hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @AfterEach // 메모리 DB내 직전 테스트 결과가 남아있을수 있기 때문에 리포지토리 초기화
    public void afterEach(){

        MemoryMemberRepository.clearStore(); // 메모리 내 저장시 과거 데이터 값을 제거 할 수 있게 초기화 진행 코드
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("kangjungu"); // 회원가입시 DB에 넘어가는 이름명
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

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}
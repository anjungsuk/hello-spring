package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberrepositorttest {

    MemoryMemberRepository repository = new MemoryMemberRepository(); //

    @AfterEach // 메모리 DB내 직전 테스트 결과가 남아있을수 있기 때문에 리포지토리 초기화
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){ //
        Member member = new Member();// 멤버 객체 생성
        member.setName("spring"); // 스프링이라는 이름 생성

        repository.save(member); //멤버 저장소 안에 저장 시킨다

        Member result = repository.findById(member.getId()).get(); // findById로 검증부 get으로 바로 꺼내는 방법은 좋지 않음.
        assertThat(member).isEqualTo(result); // 검증부 
    }
    @Test
    public void findByName(){ //spring 1 spring 2 회원이 저장됨
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }
}

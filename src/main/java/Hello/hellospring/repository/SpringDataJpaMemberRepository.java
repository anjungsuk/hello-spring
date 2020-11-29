package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, Memberrepository {
    Optional<Member> findByName(String name); //select m from Member m where m.name = ?
    //스프링 데이터 jpa로 인터페이스 이름만으로 쿼리 작성 가능
}


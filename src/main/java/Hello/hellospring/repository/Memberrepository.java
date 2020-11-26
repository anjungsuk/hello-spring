package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface Memberrepository {
    Member save(Member member); //회원 저장시 저장값에 반환된다.
    Optional<Member> findById(Long id); // DB내 아이디 찾는 문구
    Optional<Member> findByName(String name); //DB내 이름 찾는 문구
    List<Member> findAll(); // 모든 회원 리스트를 반환한다



}

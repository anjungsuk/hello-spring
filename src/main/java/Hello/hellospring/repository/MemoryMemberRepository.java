package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements Memberrepository{

    private static Map<Long, Member> store = new HashMap<>(); // 메모리 저장 구현부
    private static long sequence =0L; // 012 키값 생성



    @Override
    public Member save(Member member) {
        member.setId(++sequence); //아이디 세팅
        store.put(member.getId(), member); //스토어에 저장한다
        return member; // 결과값 반영
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //스토어에서 id를 입력한다 결과값이 없을때는 null이여도 반호나 가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                    .filter(member -> member.getName().equals(name))//파라미터로 넘어온 name 같을때만 필터링을 걸어 반환 시킨다.
                    .findAny();//map에서 한개 찾아지면 반환한다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //스토어에 있는 values들을 반환시킨다
    }

    public static void clearStore(){
        store.clear();
    }
}

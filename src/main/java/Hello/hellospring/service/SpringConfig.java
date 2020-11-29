package Hello.hellospring.service;

import Hello.hellospring.aop.TimeTraceAop;
import Hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private final Memberrepository memberrepository;

    public SpringConfig(Memberrepository memberRepository) {
        this.memberrepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberrepository);
    }

}

    //@Bean
    //public Memberrepository memberrepository() {
    //return new MemoryMemberRepository();
    //return new jdbcMemberRepository(dataSource);
    //return new JdbcTemplateMemberRepository(dataSource);
    //return new JpaMemberRepository(em);
    //}


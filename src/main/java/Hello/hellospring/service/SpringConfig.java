package Hello.hellospring.service;

import Hello.hellospring.repository.Memberrepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import Hello.hellospring.repository.jdbcMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberrepository());
    }

    @Bean
    public Memberrepository memberrepository() {
//        return new MemoryMemberRepository();
        return new jdbcMemberRepository(dataSource);
    }
}

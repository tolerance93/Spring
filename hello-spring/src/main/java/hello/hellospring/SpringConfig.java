package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig  {

    EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    // 스프링 빈에 등록하라는 걸로 인
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    // 디펜던시 인젝션, 객체지향 프로그래밍. 기존의 코드는 하나도 건드리지않고, 어플리케이셔은을 조립하는 컨피그(어셈블리)코드만 수정했음
    @Bean
    public MemberRepository memberRepository() {
        //return new JdbcMemberRepository(dataSource);
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}

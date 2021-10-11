package store.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import store.core.member.MemberRepository;
import store.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
        //어디서부터 찾는지 지정. 지정하지 않으면 맨 위 package store.core에서 시작
        //basePackages = "store.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}

package store.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import store.core.AppConfig;
import store.core.member.MemberService;
import store.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //option + enter: static import
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        //option + enter: static import
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조")
    void findBeanByName2() {
        //함수 이름의 구체 리턴타입으로도 가능. 추천하진않음!! DIP
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        //option + enter: static import
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
        //MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        //오른쪽에 있는 로직을 실행하면 왼쪽 익셉션이 터져야한다.
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }


}

package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// anotation을 보고 스프링이 생성해서 들고있음 스프링 컨테이너가 관리
@Controller
public class MemberController {

    private final MemberService memberService;

    // controller와 service 연결. 디펜던시 인젝
    // 생성자 주입. 어플리케이션이 조립되는 시점에 한번 들어고오 끝남.
    // 세터를 사용하면 변경될 일이 없을때에도 퍼블릭 메소드로 공개되어있음
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

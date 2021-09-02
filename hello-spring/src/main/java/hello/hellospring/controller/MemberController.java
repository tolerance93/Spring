package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// anotation을 보고 스프링이 생성해서 들고있음 스프링 컨테이너가 관리
@Controller
public class MemberController {

    private final MemberService memberService;

    // controller와 service 연결. 디펜던시 인젝션
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

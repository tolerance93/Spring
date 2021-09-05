package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    // 겟매핑은 조회할때 주로 사
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    // 포스트매핑은 어떤 형식에 넣어 값을 전달할때 사용
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

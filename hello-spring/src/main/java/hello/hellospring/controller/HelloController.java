package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // local:8080/address 주소에 담김
    @GetMapping("address")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        // resources/template에 있는 html파일 이름과 똑같음
        return "hello";
    }
}

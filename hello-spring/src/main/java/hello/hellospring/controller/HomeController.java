package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //localhost 8080에 들어오면 실행
    // static.index.html을 찾기전에 먼저 스프링 컨테이너에 들어있는 홈 컨트롤러를 찾음
   @GetMapping("/")
    public String home() {
        return "home";
    }
}

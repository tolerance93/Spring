package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // local:8080/address 주소에 담김
    @GetMapping("address")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        // resources/template에 있는 html파일 이름과 똑같음
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // http body부에 이 데이터를 직접 넣어주겠다. html 태그없이 문자가 그대로 들어감 (소스보기로 확인가능)
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // json 형식으로 표시됨. key : value pair
    // ResponseBody가 있으면 viewResolver가 아니라 그냥 던짐
    // 객체가 오면 json으로 만들어 던지겠다가 스프링의 기본정책 : HttpMessageConverter가 동작함
    // 객체면 JsonConverter가 동작함.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // command + N 코드 자동완성. java bean 표준방식
    // property 접근 방식
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

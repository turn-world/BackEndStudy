package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class HelloController {
    @GetMapping("hello") // 정적 컨텐츠
    public String hello(Model model){
        model.addAttribute( "data","hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc") // view를 프로그래밍을 한걸로 넘겨준것 
    public String helloMvc(@RequestParam("name") String name,Model model){
        model.addAttribute("name",name );
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody // 그대로 데이터를 내려줌
    public  String helloString(@RequestParam("name") String name){
        return "hello " + name ; // hello spring
    }
    @GetMapping("hello-api") // json 파일은 key, value들의 나열된 파일들 , api는 객체를 반환하는 것
    @ResponseBody // jackson2 와 지슨
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello  = new Hello();
        hello.setName(name);
        return hello;

    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
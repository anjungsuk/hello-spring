package Hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HellowController {
    @GetMapping("hello") //http의 url 매칭값
    public String hello(Model model){ //spring 에서 모델값 전송
        model.addAttribute("data","hello!");//data(name안에 Value값 저장) value(hello값 입력)
        return "hello"; //hello.html의 화면을 렌더링하여 data 값을 전송시킴
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name, Model model){//외부에서 파라미터를 받는다
        model.addAttribute("name", name); //파라미터에서 넘어온 name을 받는다
        return "hello-template"; //hello-template로 결과값 전송
    }
    @GetMapping("hello-string")
    @ResponseBody //http 바디부의 데이터를 직접 넣는 함수
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; //"hello string"
    }

    @GetMapping("hello-api")
    @ResponseBody //json으로 반환하는게 default 값
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); // Hello 객체생성
        hello.setName(name);//파라미터로 넘어온 name 입력
        return hello;

    }

    static class Hello{
        private  String name; //key값

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

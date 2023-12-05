package hello.hellospring.controller;

import org.apache.naming.StringManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("yellow") // /hello치고 들어올 경우
    public String Hello(Model model) {
        model.addAttribute("jata", "hellllo!!"); //Key-Value 키를 꺼내보나 Value가 들어있다
        return "yellow"; //jello.html반환? -> yes!! 이 화면을 렌더링 해라
    }

    @GetMapping("red")
    public String red(Model model) {
        model.addAttribute("data", "sayHooooo");
        return "red";
    }

    @GetMapping("Hello-mvc") //파라미터를 받는다 매핑 되어 있음/
    public String helloMvc(@RequestParam("param") String name, Model model) {
        model.addAttribute("kkk", name); // html에서 쓰이는 key- value형태
        return "helloMVC"; //helloMVC.html을 렌더링한다
    }

    @GetMapping("Hello-api")
    @ResponseBody
    public String helloApi(@RequestParam("param") String name) {
        return "fuck" + name;
    }

    @GetMapping("hello-apii")
    @ResponseBody
    public Hello helloApi2(@RequestParam("param") String name) {

        Hello hello = new Hello(name, 16);
        return hello;
    }


    static class Hello {

        String name;
        int age;
        boolean married;

        public Hello(String name, int age) {
            this.name = name;
            this.age = age;
            married = true;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public boolean isMarried() {
            return married;
        }


    }
}

package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("hello")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("msg", "Hello Spring");
        return mav;
    }

    @GetMapping("hello-mvc")
    public ModelAndView helloMvc(@RequestParam String name) {
        ModelAndView mav = new ModelAndView("hello-template");
        mav.addObject("name" , name);
        return mav;
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

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

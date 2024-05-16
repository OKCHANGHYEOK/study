package com.itbank.crud01.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(HttpSession session) {
        return "home";
    }

    @GetMapping("/alert")
    public ModelAndView alert(RedirectAttributes rttr) {
        ModelAndView mav = new ModelAndView("alert");
        if(rttr.getAttribute("msg") == null) {
            ;mav.addObject("msg", "로그인이 필요한 기능입니다. 로그인 페이지로 이동할까요?");
        }
        return mav;
    }
}

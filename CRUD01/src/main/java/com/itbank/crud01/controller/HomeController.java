package com.itbank.crud01.controller;

import jakarta.servlet.http.HttpServletRequest;
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
        String msg = (String) rttr.getFlashAttributes().get("msg");
        System.out.println(msg);
        mav.addObject("msg", msg);
        return mav;
    }
}

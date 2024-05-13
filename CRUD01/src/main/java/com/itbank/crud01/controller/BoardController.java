package com.itbank.crud01.controller;


import com.itbank.crud01.model.Board;
import com.itbank.crud01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService bs;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("/board/list");
        List<Board> list = bs.selectAll();
        mav.addObject("list", list);
        return mav;
    }

    @GetMapping("/write")
    public String write() {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(Board board) {
        try {
            bs.insert(board);
        } catch(Exception e) {
            return "/home";
        }
        return "/board/list";
    }
}

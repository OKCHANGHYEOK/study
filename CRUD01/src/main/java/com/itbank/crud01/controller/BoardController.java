package com.itbank.crud01.controller;


import com.itbank.crud01.exception.BadAccessException;
import com.itbank.crud01.exception.BadWritingTryException;
import com.itbank.crud01.exception.NoSuchBoardException;
import com.itbank.crud01.model.Board;
import com.itbank.crud01.model.Member;
import com.itbank.crud01.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService bs;

    @GetMapping("/list/{pageNum}")
    public ModelAndView list(String search, @PathVariable int pageNum) {
        ModelAndView mav = new ModelAndView("/board/list");
        if (search == null) {
            search = "";
        }
        Pageable pageable = PageRequest.of(pageNum - 1, 20);
        Page<Board> list = bs.findBySearch(search, pageable);
        mav.addObject("list", list);
        return mav;
    }

    @GetMapping("/write")
    public String write() {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(Board board, HttpSession session) throws BadWritingTryException {
        Member login = (Member) session.getAttribute("login");
        if(!(login.getUserid().equals(board.getWriter()))) {
            throw new BadWritingTryException("잘못된 작성 요청입니다");
        }
        int row = bs.insert(board);
        return "redirect:/board/list/1";
    }

    @GetMapping("/view/{idx}")
    public ModelAndView view(@PathVariable("idx") int idx) throws NoSuchBoardException {
        ModelAndView mav = new ModelAndView("/board/view");
        if(bs.selectOne(idx) == null) {
            throw new NoSuchBoardException();
        }
        bs.increaseViewCount(idx);
        Board board = bs.selectOne(idx);
        mav.addObject("board", board);
        return mav;
    }

    @GetMapping("/modify/{idx}")
    public ModelAndView modify(@PathVariable("idx") int idx, HttpSession session) throws BadAccessException, NoSuchBoardException {
        ModelAndView mav = new ModelAndView("/board/modify");
        Board board = bs.selectOne(idx);
        Member login = (Member) session.getAttribute("login");
        if(board == null) {
            throw new NoSuchBoardException();
        }
        if(login == null || !login.getUserid().equals(board.getWriter())) {
            throw new BadAccessException();
        }
        mav.addObject("board", board);
        return mav;
    }

    @PostMapping("/modify/{idx}")
    public String modify(Board board) {
        bs.modify(board);
        return "redirect:/board/view/" + board.getIdx();
    }

    @GetMapping("/delete/{idx}")
    public String delete(@PathVariable("idx") int idx, HttpSession session) throws BadAccessException {
        Member login = (Member) session.getAttribute("login");
        if(login == null || !bs.selectOne(idx).getWriter().equals(login.getUserid())) {
            throw new BadAccessException();
        }
        bs.delete(idx);
        return "redirect:/board/list";
    }
}

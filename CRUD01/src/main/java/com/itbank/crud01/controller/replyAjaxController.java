package com.itbank.crud01.controller;

import com.itbank.crud01.model.Reply;
import com.itbank.crud01.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/board/reply")
@RequiredArgsConstructor
public class replyAjaxController {

    private final ReplyService rs;

    @PostMapping("/write/{boardIdx}")
    public String write(@PathVariable int boardIdx, @RequestBody Reply reply) {
        String result = "";

        reply.setBoard_idx(boardIdx);
        result = rs.insert(reply) != 0 ? "작성 성공" : "작성 실패";

        return result;
    }
}

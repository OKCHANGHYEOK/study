package com.itbank.crud01.service;

import com.itbank.crud01.model.Reply;
import com.itbank.crud01.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository rr;

    public int insert(Reply reply) {
        try {
            rr.save(reply);
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}

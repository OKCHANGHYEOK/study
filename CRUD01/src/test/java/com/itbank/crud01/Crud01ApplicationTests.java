package com.itbank.crud01;

import com.itbank.crud01.model.Board;
import com.itbank.crud01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Crud01ApplicationTests {

    @Autowired
    private BoardService bs;

    @Test
    void contextLoads() {
    }

    @Test
    void viewTest() {
        int idx = 8;
        Board board = bs.selectOne(idx);
        System.out.println(board.getTitle());
    }
}

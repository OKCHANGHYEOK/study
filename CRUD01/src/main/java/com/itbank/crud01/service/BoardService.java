package com.itbank.crud01.service;

import com.itbank.crud01.model.Board;
import com.itbank.crud01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void insert(Board board) {
        boardRepository.insert(board);
    }

    public List<Board> selectAll() {
       return boardRepository.findAll();
    }
}

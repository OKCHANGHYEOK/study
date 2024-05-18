package com.itbank.crud01.service;

import com.itbank.crud01.model.Board;
import com.itbank.crud01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public int insert(Board board) {
        return boardRepository.insert(board);
    }

    public List<Board> selectAll() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "idx"));
    }

    public Board selectOne(int idx) {
        return boardRepository.findByIdx(idx);
    }

    public int increaseViewCount(int idx) {
        return boardRepository.increaseViewCount(idx);
    }
}

package com.itbank.crud01.repository;

import com.itbank.crud01.model.Board;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO Board (title, writer, content) VALUES (:#{#board.title}, :#{#board.writer}, :#{#board.content})")
    int insert(Board board);

    Board findByIdx(int idx);
}
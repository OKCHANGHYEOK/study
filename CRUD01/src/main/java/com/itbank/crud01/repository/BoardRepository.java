package com.itbank.crud01.repository;

import com.itbank.crud01.model.Board;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO Board (title, writer, content) VALUES (:#{#board.title}, :#{#board.writer}, :#{#board.content})")
    int insert(Board board);

    Board findByIdx(int idx);

    @Modifying
    @Transactional
    @Query("update Board set viewcount = viewcount + 1 where idx = :idx")
    int increaseViewCount(int idx);

    @Modifying
    @Transactional
    @Query("update Board set title = :#{#board.title}, content = :#{#board.content} where idx = :#{#board.idx}")
    void modify(Board board);

    @Modifying
    @Transactional
    @Query("delete from Board b where b.idx = :idx")
    void deleteByIdx(int idx);

    @Query("select b from Board b where b.title like %:search% or b.writer like %:search% or b.content like %:search% order by b.idx desc")
    List<Board> selectList(String search);
}
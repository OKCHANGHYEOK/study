package com.itbank.crud01.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private int board_idx;
    private String userid;
    private String content;

    @CreationTimestamp
    @Column(name = "writedate")
    private Date writedate;
}

package com.chessblog.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Move{
    @Id
    private Long id;

    private String move;
    private String explanation;
    private String fen;

    @ManyToOne
    private Game game;

}

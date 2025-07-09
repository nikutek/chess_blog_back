package com.chessblog.backend;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Game {
    @Id
    private Long id;
    private String title;

    @OneToMany
    private List<Move> moves;
}

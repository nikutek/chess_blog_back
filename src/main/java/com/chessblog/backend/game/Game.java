package com.chessblog.backend.game;

import java.util.ArrayList;
import java.util.List;

import com.chessblog.backend.move.Move;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Move> moves = new ArrayList<>();

    public Long getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void addMove(Move move){
        moves.add(move);
    }

    public void removeMove(Move move){
        moves.remove(move);
        move.setGame(null);
    }


}

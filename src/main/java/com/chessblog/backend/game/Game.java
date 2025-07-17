package com.chessblog.backend.game;

import java.util.ArrayList;
import java.util.List;

import com.chessblog.backend.move.Move;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Move> moves = new ArrayList<>();

    public Game() {
        Move startingPositionMove = new Move();
        startingPositionMove.setMove("start");
        startingPositionMove.setExplanation("Starting position");
        startingPositionMove.setFen("rn1qkbnr/ppp1pppp/8/3p4/8/5NP1/PPPPPPBP/RNBQK2R w KQkq - 0 1");
        startingPositionMove.setGame(this);
        moves.add(startingPositionMove);
    }

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
        move.setGame(this);
        moves.add(move);
    }

    public void removeMove(Move move){
        moves.remove(move);
        move.setGame(null);
    }


}

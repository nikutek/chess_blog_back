package com.chessblog.game;

import com.chessblog.move.Move;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameID;
    private String name;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Move> moves = new LinkedList<>();

    public Game(){
        this.name = "brak nazwy";
        this.moves = new LinkedList<>();
    }

    public Game(String name, List<Move> moves) {
        this.name = name;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return gameID;
    }

    public void setId(Integer id) {
        this.gameID = id;
    }

    public void addMove(Move move){
        this.moves.add(move);
        move.setGame(this);
    }

    public void removeMove(Move move){
        this.moves.remove(move);
        move.setGame(null);
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(gameID, game.gameID) && Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameID, name);
    }
}

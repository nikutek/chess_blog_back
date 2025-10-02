package com.chessblog;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer game_id;
    private String name;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Move> moves = new LinkedList<>();

    public Game(){
        this.name = "puste";
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
        return game_id;
    }

    public void setId(Integer id) {
        this.game_id = id;
    }

    public void addMove(Move move){

        this.moves.add(move);
        move.setGame(this);
    }

    public void removeMove(Move move){
        this.moves.remove(move);
        move.setGame(null);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(game_id, game.game_id) && Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, name);
    }
}

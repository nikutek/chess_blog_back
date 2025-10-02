package com.chessblog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String notation;
    private String fen;
    private String explanation;
    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonBackReference
    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Move() {
    }

    public Move(String notation, String fen, String explanation) {
        this.notation = notation;
        this.fen = fen;
        this.explanation = explanation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public String getFen() {
        return fen;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(id, move.id) && Objects.equals(notation, move.notation) && Objects.equals(fen, move.fen) && Objects.equals(explanation, move.explanation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, notation, fen, explanation);
    }
}

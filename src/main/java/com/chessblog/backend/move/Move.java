package com.chessblog.backend.move;

import com.chessblog.backend.game.Game;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Move{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private String move;
    private String explanation;
    private String fen;

    public void setGame(Game game) {
        this.game = game;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    @Override
    public String toString() {
        return "Move [id=" + id + ", game=" + game + ", move=" + move + ", explanation=" + explanation + ", fen=" + fen
                + "]";
    }

    

}

package com.chessblog.game.dto;

import com.chessblog.move.Move;

import java.util.List;

public record GameDTO(
        Integer gameID,
        String name,
        List<Move> moves) {
}

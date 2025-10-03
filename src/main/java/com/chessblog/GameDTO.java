package com.chessblog;

import java.util.List;

public record GameDTO(
        Integer gameID,
        String name,
        List<Move> moves) {
}

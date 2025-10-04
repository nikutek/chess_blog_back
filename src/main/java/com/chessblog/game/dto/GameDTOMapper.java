package com.chessblog.game.dto;

import com.chessblog.game.Game;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GameDTOMapper implements Function<Game, GameDTO> {
    @Override
    public GameDTO apply(Game game) {
        return new GameDTO(
                game.getId(),
                game.getName(),
                game.getMoves() //Możliwe że trzeba mapping
        );
    }
}

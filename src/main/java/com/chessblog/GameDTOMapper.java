package com.chessblog;

import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
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

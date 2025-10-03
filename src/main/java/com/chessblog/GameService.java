package com.chessblog;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final GameDTOMapper gameDTOMapper;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.gameDTOMapper = new GameDTOMapper();
    }

    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    public void insertGame(Game game) {
        gameRepository.save(game);
    }

    public Game getGameById(Integer id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + "not found"));
    }

    public void editGame(Integer id, Game game) {
        if (gameRepository.existsById(id)) {
            game.setId(id);
            gameRepository.save(game);
        } else {
            throw new IllegalStateException(id + "not found");
        }
    }

    public void deleteGameById(Integer id) {
        if(gameRepository.existsById(id)){
            gameRepository.deleteById(id);
        } else {
            throw new IllegalStateException(id + "not found");
        }
    }
}

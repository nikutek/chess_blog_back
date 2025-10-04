package com.chessblog.game;

import com.chessblog.Move;
import com.chessblog.game.exceptions.GameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    public void createGame(Game game) {
        gameRepository.save(game);
    }

    public Game getGameById(Integer id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
    }

    public void addMoveToGame(Integer id, Move move){
        Game game = getGameById(id);
        game.addMove(move);
        gameRepository.save(game);
    }

    public void editGame(Integer id, Game game) {
        if (!gameRepository.existsById(id)) {
            throw new GameNotFoundException(id);
        }
        game.setId(id);
        gameRepository.save(game);
    }

    public void deleteGameById(Integer id) {
        if(!gameRepository.existsById(id)){
            throw new GameNotFoundException(id);
        }
        gameRepository.deleteById(id);
    }

    public void updateGameName(Integer id, String name) {
        Game game = getGameById(id);
        game.setName(name);
        gameRepository.save(game);
    }
}

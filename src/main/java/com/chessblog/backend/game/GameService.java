package com.chessblog.backend.game;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chessblog.backend.move.Move;

import jakarta.transaction.Transactional;

// co to DTO i dlaczego powinienem tego uzywac?

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional
    public Game createGame(String title) {
        Game game = new Game();
        game.setTitle(title);

        return gameRepository.save(game);
    }

    public Game addMoveToGame(Long gameId, Move move) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Game not found with id: " + gameId));
        game.addMove(move); // This sets the game reference
        return gameRepository.save(game);
    }

    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameRepository.findAll();
        return ResponseEntity.ok(games);
    }

    public Optional<Game> getGameById(Long gameId) {
        return gameRepository.findById(gameId);
    }
    
}

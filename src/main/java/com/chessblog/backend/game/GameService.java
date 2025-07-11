package com.chessblog.backend.game;

import org.springframework.stereotype.Service;

import com.chessblog.backend.move.Move;

import jakarta.transaction.Transactional;

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
        move.setGame(game);
        game.addMove(move);
        return gameRepository.save(game);
    }

}

package com.chessblog.backend.game;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chessblog.backend.move.Move;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/create")
    public Game createGame(@RequestParam String title) {
        return gameService.createGame(title);
    }

    @PostMapping("/{gameId}/addMove")
    public Game addMove(
        @PathVariable Long gameId,
        @RequestParam String move,
        @RequestParam String fen,
        @RequestParam String explanation
    ) {
        Move newMove = new Move();
        newMove.setMove(move);
        newMove.setFen(fen);
        newMove.setExplanation(explanation);
        return gameService.addMoveToGame(gameId, newMove);
    }
}

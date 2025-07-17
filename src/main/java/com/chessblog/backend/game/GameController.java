package com.chessblog.backend.game;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chessblog.backend.move.Move;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Game>> getGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{gameId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Game> getGame(@PathVariable Long gameId) {
        return gameService.getGameById(gameId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
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

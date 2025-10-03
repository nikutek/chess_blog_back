package com.chessblog;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {
    final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameDTO> getGames(){
        return gameService.getGames();
    }

    @GetMapping("{id}")
    public Game getGameById(@PathVariable Integer id){
        return gameService.getGameById(id);
    }

    @PostMapping
    public void addGame(@RequestBody Game game){
        gameService.insertGame(game);
    }
    @PostMapping("{id}/moves")
    public void addMove(@PathVariable int id, @RequestBody Move move){
        Game game = gameService.getGameById(id);
        game.addMove(move);
        gameService.insertGame(game);
    }

    @PutMapping("{id}")
    public void updateGame(@PathVariable Integer id, @RequestBody Game game){
        gameService.editGame(id, game);
    }

    @DeleteMapping("{id}")
    public void deleteGame(@PathVariable Integer id){
        gameService.deleteGameById(id);
    }
}

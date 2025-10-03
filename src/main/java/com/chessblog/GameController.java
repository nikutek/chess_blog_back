package com.chessblog;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("games")
public class GameController {
    final GameService gameService;
    private final GameDTOMapper gameDTOMapper;

    public GameController(GameService gameService) {
        this.gameService = gameService;
        this.gameDTOMapper = new GameDTOMapper();
    }

    @GetMapping
    public List<GameDTO> getGames(){
        return gameService.getGames().stream().map(gameDTOMapper).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public GameDTO getGameById(@PathVariable Integer id){
        return gameDTOMapper.apply(gameService.getGameById(id));
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

    @PatchMapping("{id}")
    public void updateGame(@PathVariable Integer id, @RequestBody Map<String, Object> updates){
        Game game = gameService.getGameById(id);
        if (updates.containsKey("name")){
            game.setName(updates.get("name").toString());
        }
        if(updates.containsKey("moves")){
            game.setMoves((List<Move>) updates.get("moves"));
        }
        gameService.insertGame(game);
    }


    @DeleteMapping("{id}")
    public void deleteGame(@PathVariable Integer id){
        gameService.deleteGameById(id);
    }
}

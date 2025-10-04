package com.chessblog.game;

import com.chessblog.Move;
import com.chessblog.game.dto.GameDTO;
import com.chessblog.game.dto.GameDTOMapper;
import com.chessblog.game.dto.GameUpdateDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        gameService.createGame(game);
    }
    @PostMapping("{id}/moves")
    public void addMove(@PathVariable int id, @RequestBody Move move){
        gameService.addMoveToGame(id, move);
    }

    @PatchMapping("{id}")
    public void updateGame(@PathVariable Integer id, @RequestBody GameUpdateDTO dto){
        gameService.updateGameName(id, dto.name());
    }


    @DeleteMapping("{id}")
    public void deleteGame(@PathVariable Integer id){
        gameService.deleteGameById(id);
    }
}

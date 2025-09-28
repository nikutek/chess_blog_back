package com.chessblog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {
    @GetMapping
    public List<Game> getGames(){
        return List.of( new Game("hujson", 1), new Game("eueu", 2));
    }
}

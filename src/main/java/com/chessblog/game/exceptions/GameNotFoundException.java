package com.chessblog.game.exceptions;

public class GameNotFoundException extends RuntimeException{
    public GameNotFoundException(Integer id){
        super("Game " + id + " not found");
    }
}

package com.chessblog.game.exceptions;


public class DuplicateGameNameException extends RuntimeException {
    public DuplicateGameNameException(String name) {
        super("Game with name " + name + " already exists");
    }
}

package com.example.Pawtropolis.game.command;


import com.example.Pawtropolis.game.controller.GameController;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Command <T>{
    private final GameController gameController;

    public abstract T execute();
}

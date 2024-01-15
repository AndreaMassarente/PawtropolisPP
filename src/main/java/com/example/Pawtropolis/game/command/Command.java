package com.example.Pawtropolis.game.command;

import com.example.Pawtropolis.game.controller.GameController;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public abstract class Command <T>{
    private final GameController gameController;

    @Autowired
    public Command(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract T execute();
}

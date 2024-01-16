package com.example.Pawtropolis.game.command;

import com.example.Pawtropolis.game.controller.GameManager;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter
public abstract class Command <T>{
    private final GameManager gameManager;

    @Autowired
    protected Command(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public abstract T execute();
}

package com.example.Pawtropolis.game.command.implementation;


import com.example.Pawtropolis.game.command.Command;
import com.example.Pawtropolis.game.controller.GameManager;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends Command<String> {
    public LookCommand(GameManager gameManager){
        super(gameManager);
    }

    @Override
    public String execute(){
        return getGameManager().getMapManager().lookCurrentRoom();
    }
}
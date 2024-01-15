package com.example.Pawtropolis.game.command.implementation;


import com.example.Pawtropolis.game.command.Command;
import com.example.Pawtropolis.game.controller.GameController;
import org.springframework.stereotype.Component;

@Component("lookCommand")
public class LookCommand extends Command<String> {
    public LookCommand(GameController gameController){
        super(gameController);
    }

    @Override
    public String execute(){
        return getGameController().getMapController().lookCurrentRoom();
    }
}

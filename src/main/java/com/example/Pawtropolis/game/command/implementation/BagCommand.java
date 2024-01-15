package com.example.Pawtropolis.game.command.implementation;

import com.example.Pawtropolis.game.command.Command;
import com.example.Pawtropolis.game.controller.GameController;
import org.springframework.stereotype.Component;

@Component("bagCommand")
public class BagCommand extends Command<String> {
    public BagCommand(GameController gameController){
        super(gameController);
    }

    @Override
    public String execute(){
        return getGameController().getPlayer().geItemsInBag();
    }
}

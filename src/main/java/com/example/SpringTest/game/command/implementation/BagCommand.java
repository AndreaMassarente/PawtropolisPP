package com.example.SpringTest.game.command.implementation;


import com.example.SpringTest.game.command.Command;
import com.example.SpringTest.game.controller.GameController;
import org.springframework.stereotype.Component;


@Component
public class BagCommand extends Command<String> {
    public BagCommand(GameController gameController){
        super(gameController);
    }

    @Override
    public String execute(){
        return getGameController().getPlayer().geItemsInBag();
    }
}

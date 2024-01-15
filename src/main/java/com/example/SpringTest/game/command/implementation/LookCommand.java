package com.example.SpringTest.game.command.implementation;


import com.example.SpringTest.game.command.Command;
import com.example.SpringTest.game.controller.GameController;

//@Component
public class LookCommand extends Command<String> {
    public LookCommand(GameController gameController){
        super(gameController);
    }

    @Override
    public String execute(){
        return getGameController().getMapController().lookCurrentRoom();
    }
}

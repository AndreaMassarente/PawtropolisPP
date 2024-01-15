package com.example.SpringTest.game.command.implementation;

import com.example.SpringTest.game.command.ParametrizedCommand;
import com.example.SpringTest.game.controller.GameController;
import com.example.SpringTest.game.model.Item;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.logging.Level;

@Log
//@Component
public class DropCommand extends ParametrizedCommand<Void> {
    public DropCommand(GameController gameController){
        super(gameController);
    }
    public DropCommand(GameController gameController, ArrayList<String> parameter){
        super(gameController, parameter);
    }

    @Override
    public Void execute(){
        Item item = getGameController().getMapController().getChosenItemInRoom(getParameter().getFirst());

        if(getParameter().size() != 1){
            log.log(Level.WARNING, "Incorrect parameter for drop command!");
            return null;
        }

        if (item == null) {
            log.log(Level.WARNING, "no {0} in bag", getParameter());
        } else  {
            getGameController().getPlayer().removeItemFromBag(item);
            getGameController().getMapController().addItemInRoom(item);
        }
        return null;
    }


}

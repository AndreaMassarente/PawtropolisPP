package com.example.Pawtropolis.game.command.implementation;


import com.example.Pawtropolis.game.command.ParametrizedCommand;
import com.example.Pawtropolis.game.controller.GameController;
import com.example.Pawtropolis.game.model.Item;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.logging.Level;

@Log
//@Component
public class GetCommand extends ParametrizedCommand<Void> {
    public GetCommand(GameController gameController, ArrayList<String> parameter){
        super(gameController, parameter);
    }

    public GetCommand(GameController gameController){
        super(gameController);
    }
    @Override
    public Void execute() {
        Item item = getGameController().getMapController().getChosenItemInRoom(getParameter().getFirst());

        if(getParameter().size() != 1){
            log.log(Level.WARNING, "Incorrect parameter for get command!");
            return null;
        }

        if (item == null) {
            log.log(Level.WARNING,"no {0} in room", getParameter());
        } else if (!getGameController().getPlayer().addItemInBag(item)) {
            log.info("no enough space in bag");
        } else {
            getGameController().getMapController().removeItemInRoom(item);
        }
        return null;
    }
}

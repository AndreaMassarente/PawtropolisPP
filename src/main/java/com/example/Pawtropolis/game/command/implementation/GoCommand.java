package com.example.Pawtropolis.game.command.implementation;


import com.example.Pawtropolis.game.command.ParametrizedCommand;
import com.example.Pawtropolis.game.controller.GameController;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.logging.Level;

@Log
//@Component
public class GoCommand extends ParametrizedCommand<String> {
    public GoCommand(GameController gameController, ArrayList<String> parameter){
        super(gameController, parameter);
    }

    public GoCommand(GameController gameController){
        super(gameController);
    }

    @Override
    public String execute(){
        if(getParameter().size() != 1){
            log.log(Level.WARNING, "Incorrect parameter for get command!");
            return null;
        }

        return getGameController().getMapController().changeCurrentRoom(getParameter().getFirst());
    }

}

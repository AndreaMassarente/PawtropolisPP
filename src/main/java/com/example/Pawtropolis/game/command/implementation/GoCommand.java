package com.example.Pawtropolis.game.command.implementation;

import com.example.Pawtropolis.game.command.ParametrizedCommand;
import com.example.Pawtropolis.game.controller.GameController;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.logging.Level;

@Log
@Component("goCommand")
public class GoCommand extends ParametrizedCommand<String> {
    @Autowired
    public GoCommand(GameController gameController, ArrayList<String> parameter){
        super(gameController, parameter);
    }

    public GoCommand(GameController gameController){
        super(gameController);
    }

    @Override
    public String execute(){
        if(getParameter().size() != 1){
            log.log(Level.WARNING, "Incorrect parameter for go command!");
            return null;
        }
        return getGameController().getMapController().changeCurrentRoom(getParameter().getFirst());
    }

}

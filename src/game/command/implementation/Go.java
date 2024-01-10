package game.command.implementation;

import game.command.ParametrizedCommand;
import game.controller.CommandFactory;
import game.controller.GameController;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log
public class Go extends ParametrizedCommand<String> {
    public Go(GameController gameController, ArrayList<String> parameter){
        super(gameController, parameter);
    }

    public Go (GameController gameController){
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

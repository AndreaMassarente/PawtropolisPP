package game.command.implementation;

import game.command.ParametrizedCommand;
import game.controller.GameController;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Go extends ParametrizedCommand<String> {
    public Go(GameController gameController, ArrayList<String> parameter){
        super(gameController, parameter);
    }

    public Go (GameController gameController){
        super(gameController);
    }

    @Override
    public String execute(){
        Logger logger = Logger.getLogger(getClass().getName());

        if(getParameter().size() != 1){
            logger.log(Level.WARNING, "Incorrect parameter for get command!");
            return null;
        }

        return getGameController().getMapController().changeCurrentRoom(getParameter().getFirst());
    }

}

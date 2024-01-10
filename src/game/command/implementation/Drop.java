package game.command.implementation;

import game.command.ParametrizedCommand;
import game.controller.CommandFactory;
import game.controller.GameController;
import game.model.Item;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log
public class Drop extends ParametrizedCommand<Void> {
    public Drop(GameController gameController){
        super(gameController);
    }
    public Drop(GameController gameController, ArrayList<String> parameter){
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

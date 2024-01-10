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
public class Get extends ParametrizedCommand<Void> {
    public Get(GameController gameController, ArrayList<String> parameter){
        super(gameController, parameter);
    }

    public Get(GameController gameController){
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

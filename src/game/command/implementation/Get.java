package game.command.implementation;

import game.command.ParametrizedCommand;
import game.controller.CommandFactory;
import game.model.Item;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Get extends ParametrizedCommand<Void> {
    public Get(CommandFactory commandFactory, ArrayList<String> parameter){
        super(commandFactory, parameter);
    }

    public Get(CommandFactory commandFactory){
        super(commandFactory);
    }
    @Override
    public Void execute() {
        Item item = getCommandRunner().getMapController().getChosenItemInRoom(getParameter().getFirst());
        Logger logger = Logger.getLogger(getClass().getName());

        if(getParameter().size() != 1){
            logger.log(Level.WARNING, "Incorrect parameter for get command!");
            return null;
        }

        if (item == null) {
            logger.log(Level.WARNING,"no {0} in room", getParameter());
        } else if (!getCommandRunner().getPlayer().addItemInBag(item)) {
            logger.info("no enough space in bag");
        } else {
            getCommandRunner().getMapController().removeItemInRoom(item);
        }
        return null;
    }
}

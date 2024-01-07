package game.command.implementation;

import game.command.CommandWithParameter;
import game.controller.CommandFactory;
import game.model.Item;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Get extends CommandWithParameter<Void> {
    public Get(CommandFactory commandFactory, ArrayList<String> parameter){
        super(commandFactory, parameter);
    }

    @Override
    public Void execute() {
        Item item = getCommandRunner().getMapController().getCurrentRoom().getItemByString(getParameter().getFirst());
        Logger logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.log(Level.WARNING,"no {0} in room", getParameter());
        } else if (!getCommandRunner().getPlayer().addItemInBag(item)) {
            logger.info("no enough space in bag");
        } else {
            getCommandRunner().getMapController().getCurrentRoom().removeItem(item);
        }
        return null;
    }
}
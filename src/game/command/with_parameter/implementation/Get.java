package game.command.with_parameter.implementation;

import game.controller.CommandFactory;
import game.model.Item;
import game.command.with_parameter.CommandWithParameter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Get extends CommandWithParameter <Void>{
    public Get(CommandFactory commandFactory, String parameter){
        super(commandFactory, parameter);
    }

    @Override
    public Void execute() {
        Item item = getCommandRunner().getMapController().getCurrentRoom().getItemByString(getParameter());
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

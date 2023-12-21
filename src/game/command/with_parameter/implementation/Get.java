package game.command.with_parameter.implementation;

import game.controller.CommandRunner;
import game.model.Item;
import game.command.with_parameter.CommandWithParameter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Get extends CommandWithParameter <Void>{
    public Get(CommandRunner commandRunner, String parameter){
        super(commandRunner, parameter);
    }

    @Override
    public Void execute() {
        Item item = getCommandRunner().getMapController().getCurrentRoom().getItemByString(getParameter());
        Logger logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.log(Level.WARNING,"no {0} in room", getParameter());
        } else if (!getCommandRunner().getPlayer().getBag().addItem(item)) {
            logger.info("no enough space in bag");
        } else {
            getCommandRunner().getMapController().getCurrentRoom().removeItem(item);
        }
        return null;
    }
}

package game.util.command.with_parameter.implementation;

import game.controller.CommandRunner;
import game.model.Item;
import game.util.command.with_parameter.CommandWithParameter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Drop extends CommandWithParameter {
    public Drop(CommandRunner commandRunner, String parameter){
        super(commandRunner, parameter);
    }

    @Override
    public Void execute(){
        Item item = getCommandRunner().getPlayer().getBag().getItemByString(getParameter());
        Logger logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.log(Level.WARNING, "no {0} in bag", getParameter());
        } else  {
            getCommandRunner().getPlayer().getBag().removeItem(item);
            getCommandRunner().getMapController().getCurrentRoom().addItem(item);
        }
        return null;
    }

}

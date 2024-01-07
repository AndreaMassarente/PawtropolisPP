package game.command.implementation;

import game.command.Command;
import game.command.CommandWithParameter;
import game.controller.CommandFactory;
import game.model.Item;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Drop extends CommandWithParameter<Void> {
    public Drop(CommandFactory commandFactory){
        super(commandFactory);
    }
    public Drop(CommandFactory commandFactory, ArrayList<String> parameter){
        super(commandFactory, parameter);
    }

    @Override
    public Void execute(){
        Item item = getCommandRunner().getPlayer().getBag().getItemByString(getParameter().getFirst());
        Logger logger = Logger.getLogger(getClass().getName());

        if(getParameter().size() != 1){
            logger.log(Level.WARNING, "Incorrect parameter for drop command!");
            return null;
        }

        if (item == null) {
            logger.log(Level.WARNING, "no {0} in bag", getParameter());
        } else  {
            getCommandRunner().getPlayer().getBag().removeItem(item);
            getCommandRunner().getMapController().getCurrentRoom().addItem(item);
        }
        return null;
    }


}

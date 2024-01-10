package game.command.implementation;

import game.command.ParametrizedCommand;
import game.controller.CommandFactory;
import game.model.Item;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Drop extends ParametrizedCommand<Void> {
    public Drop(CommandFactory commandFactory){
        super(commandFactory);
    }
    public Drop(CommandFactory commandFactory, ArrayList<String> parameter){
        super(commandFactory, parameter);
    }

    @Override
    public Void execute(){
        Item item = getCommandRunner().getMapController().getChosenItemInRoom(getParameter().getFirst());
        Logger logger = Logger.getLogger(getClass().getName());

        if(getParameter().size() != 1){
            logger.log(Level.WARNING, "Incorrect parameter for drop command!");
            return null;
        }

        if (item == null) {
            logger.log(Level.WARNING, "no {0} in bag", getParameter());
        } else  {
            getCommandRunner().getPlayer().removeItemFromBag(item);
            getCommandRunner().getMapController().addItemInRoom(item);
        }
        return null;
    }


}
package game.command.implementation;

import game.command.ParametrizedCommand;
import game.controller.CommandFactory;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Go extends ParametrizedCommand<String> {
    public Go(CommandFactory commandFactory, ArrayList<String> parameter){
        super(commandFactory, parameter);
    }

    public Go (CommandFactory commandFactory){
        super(commandFactory);
    }

    @Override
    public String execute(){
        Logger logger = Logger.getLogger(getClass().getName());

        if(getParameter().size() != 1){
            logger.log(Level.WARNING, "Incorrect parameter for get command!");
            return null;
        }

        return getCommandRunner().getMapController().changeCurrentRoom(getParameter().getFirst());
    }

}

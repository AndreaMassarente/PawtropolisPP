package game.command.implementation;

import game.command.CommandWithParameter;
import game.controller.CommandFactory;

import java.util.ArrayList;
import java.util.List;

public class Go extends CommandWithParameter<String> {
    public Go(CommandFactory commandFactory, ArrayList<String> parameter){
        super(commandFactory, parameter);
    }

    @Override
    public String execute(){
        return getCommandRunner().getMapController().changeCurrentRoom(getParameter().getFirst());
    }

}

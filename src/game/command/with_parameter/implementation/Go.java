package game.command.with_parameter.implementation;

import game.controller.CommandFactory;

import game.command.with_parameter.CommandWithParameter;

public class Go extends CommandWithParameter <String>{
    public Go(CommandFactory commandFactory, String parameter){
        super(commandFactory, parameter);
    }

    @Override
    public String execute(){
        return getCommandRunner().getMapController().changeCurrentRoom(getParameter());
    }

}

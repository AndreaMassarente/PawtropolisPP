package game.util.command.with_parameter.implementation;

import game.controller.CommandRunner;

import game.util.command.with_parameter.CommandWithParameter;

public class Go extends CommandWithParameter <String>{
    public Go(CommandRunner commandRunner, String parameter){
        super(commandRunner, parameter);
    }

    @Override
    public String execute(){
        return getCommandRunner().getMapController().changeCurrentRoom(getParameter());
    }

}

package game.util.command.implementation;


import game.controller.CommandRunner;
import game.util.command.Command;

public class Look extends Command {
    public Look(CommandRunner commandRunner){
        super(commandRunner);
    }

    @Override
    public String execute(){
        return getCommandRunner().getMapController().getCurrentRoom().look();
    }
}

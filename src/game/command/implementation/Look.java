package game.command.implementation;


import game.command.Command;
import game.controller.CommandRunner;

public class Look extends Command<String> {
    public Look(CommandRunner commandRunner){
        super(commandRunner);
    }

    @Override
    public String execute(){
        return getCommandRunner().getMapController().getCurrentRoom().look();
    }
}

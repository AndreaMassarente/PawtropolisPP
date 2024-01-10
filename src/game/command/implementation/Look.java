package game.command.implementation;


import game.command.Command;
import game.controller.CommandFactory;

public class Look extends Command<String> {
    public Look(CommandFactory commandFactory){
        super(commandFactory);
    }

    @Override
    public String execute(){
        return getCommandRunner().getMapController().lookCurrentRoom();
    }
}

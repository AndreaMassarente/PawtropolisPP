package game.command.implementation;

import game.controller.CommandRunner;
import game.command.Command;

public class Bag extends Command <String> {
    public Bag(CommandRunner commandRunner){
        super(commandRunner);
    }

    @Override
    public String execute(){
        return getCommandRunner().getPlayer().getBag().getItemsToString();
    }
}

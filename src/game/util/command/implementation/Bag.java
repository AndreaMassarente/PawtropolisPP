package game.util.command.implementation;

import game.controller.CommandRunner;
import game.util.command.Command;

public class Bag extends Command <String> {
    public Bag(CommandRunner commandRunner){
        super(commandRunner);
    }

    @Override
    public String execute(){
        return getCommandRunner().getPlayer().getBag().getItemsToString();
    }
}

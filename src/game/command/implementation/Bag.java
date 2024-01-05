package game.command.implementation;

import game.controller.CommandFactory;
import game.command.Command;

public class Bag extends Command <String> {
    public Bag(CommandFactory commandFactory){
        super(commandFactory);
    }

    @Override
    public String execute(){
        return getCommandRunner().getPlayer().getBag().getItemsToString();
    }
}

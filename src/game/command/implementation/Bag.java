package game.command.implementation;

import game.command.Command;
import game.controller.CommandFactory;

public class Bag extends Command<String> {
    public Bag(CommandFactory commandFactory){
        super(commandFactory);
    }

    @Override
    public String execute(){
        return getCommandRunner().getPlayer().getElementInBag();
    }
}

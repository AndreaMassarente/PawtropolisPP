package game.command.implementation;

import game.command.Command;
import game.controller.CommandFactory;

public class Quit extends Command<String> {
    public Quit(CommandFactory commandFactory) {
        super(commandFactory);
    }

    @Override
    public String execute() {
        return "quit";
    }
}

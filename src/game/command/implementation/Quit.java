package game.command.implementation;

import game.command.Command;
import game.controller.CommandFactory;
import game.controller.GameController;

public class Quit extends Command<String> {
    public Quit(GameController gameController) {
        super(gameController);
    }

    @Override
    public String execute() {
        return "quit";
    }
}

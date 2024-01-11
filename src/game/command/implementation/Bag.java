package game.command.implementation;

import game.command.Command;
import game.controller.CommandFactory;
import game.controller.GameController;

public class Bag extends Command<String> {
    public Bag(GameController gameController){
        super(gameController);
    }

    @Override
    public String execute(){
        return getGameController().getPlayer().geItemsInBag();
    }
}

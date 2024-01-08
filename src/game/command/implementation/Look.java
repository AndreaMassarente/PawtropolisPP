package game.command.implementation;


import game.command.Command;
import game.controller.GameController;

public class Look extends Command<String> {
    public Look(GameController gameController){
        super(gameController);
    }

    @Override
    public String execute(){
        return getGameController().getMapController().lookCurrentRoom();
    }
}

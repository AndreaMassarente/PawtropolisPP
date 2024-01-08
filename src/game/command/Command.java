package game.command;

import game.controller.GameController;

public abstract class Command <T>{
    //TODO: Valutare di rendere command un'interfaccia
    private final GameController gameController;

    protected Command(GameController gameController) {
        this.gameController = gameController;
    }

    public GameController getGameController() {
        return gameController;
    }

    public abstract T execute();
}

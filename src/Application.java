import game.controller.GameController;
import game.model.Player;

public class Application {
    public static void main(String[] args) {
        Player player = new Player("Prince");
        GameController gameController = new GameController(player);
        gameController.runGame();
    }
}

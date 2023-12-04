import game.GameController;
import game.domain.Player;
import map.domain.Room;

public class Application {
    public static void main(String[] args) {
        Player player = new Player();
        Room entry = new Room();
        GameController gameController = new GameController(entry, player);
        gameController.runGame();
    }
}

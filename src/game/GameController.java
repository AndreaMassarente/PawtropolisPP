package game;

import game.console.InputController;
import game.domain.Player;
import map.domain.Room;

public class GameController {
    private final Room entry;
    private final Player player;

    public GameController(Room entry, Player player) {
        this.entry = entry;
        this.player = player;
    }

    public void runGame() {
        Room currentRoom = entry;
        boolean gameEnded = false;

        while(!gameEnded) {
            String input;
            System.out.println("Where are you going to go?");
            System.out.print(">");
            input = InputController.readString();

            /*
             * Inserire qui la gestione degli altri comandi
             */


            if (input.equals("exit")) {
                gameEnded = true;
            }
        }
    }
}

package game.controllers;

import game.controllers.console.InputController;
import game.controllers.console.InputReader;
import game.model.Player;
import java.util.logging.Logger;

public class GameController {
    private final Player player;
    private InputController inputController;

    public GameController(Player player) {
        this.player = player;
    }

    public void runGame() {
        boolean gameEnded = false;
        String input;
        String output;
        Logger logger = Logger.getLogger(getClass().getName());
        System.out.println("Hey " + player.getName() + "! Welcome to Pawtropolis!");
        while (!gameEnded){
            System.out.println("What do you want to do?");
            System.out.print(">");
            input = InputReader.readString();
            output = inputController.readCommand(input);
            if(!output.trim().equalsIgnoreCase("quit"))
                System.out.println(output);
            else{
                logger.info(output);
                gameEnded = true;
            }
        }
    }
}

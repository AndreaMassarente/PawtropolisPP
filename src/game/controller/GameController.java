package game.controller;

import game.controller.console.InputManager;
import game.controller.console.InputReader;
import game.model.Player;
import java.util.logging.Logger;

public class GameController {
    private final Player player;
    private final InputManager inputManager;

    public GameController(Player player) {
        this.player = player;
        inputManager = new InputManager();
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
            output = inputManager.readCommand(input);
            if(!output.trim().equalsIgnoreCase("quit"))
                System.out.println(output);
            else{
                logger.info(output);
                gameEnded = true;
            }
        }
    }
}

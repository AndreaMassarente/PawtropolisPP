package com.example.Pawtropolis.game.controller;

import com.example.Pawtropolis.game.controller.console.InputManager;
import com.example.Pawtropolis.game.controller.console.InputReader;
import com.example.Pawtropolis.game.model.Player;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Log
@Service
public class GameController {
    @Getter
    private final Player player;
    @Getter
    private final MapController mapController;
    private final InputManager inputManager;

    public GameController(Player player, InputManager inputManager, MapController mapController) {
        this.player = player;
        this.mapController = mapController;
        mapController.generateMap();
        this.inputManager = inputManager;
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

package com.example.Pawtropolis.game.service;

import com.example.Pawtropolis.game.service.console.InputManager;
import com.example.Pawtropolis.game.service.console.InputReader;
import com.example.Pawtropolis.game.model.Player;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Getter
@Log
@Service
public class GameManager {
    private final Player player;
    private final MapManager mapManager;
    private final InputManager inputManager;

    public GameManager(Player player, InputManager inputManager, MapManager mapManager) {
        this.player = player;
        this.mapManager = mapManager;
        this.inputManager = inputManager;
    }

    public void runGame() {
        boolean gameEnded = false;
        String input;
        String output;
        Logger logger = Logger.getLogger(getClass().getName());
        setPlayerName();
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

    public void setPlayerName(){
        System.out.println("Hi! What's your name?");
        player.setName(InputReader.readString());
    }
}

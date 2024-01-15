package com.example.Pawtropolis.game.command.implementation;


import com.example.Pawtropolis.game.command.Command;
import com.example.Pawtropolis.game.controller.GameController;
import lombok.extern.java.Log;

import java.util.logging.Level;

@Log
//@Component
public class UnknownCommand extends Command {
    public UnknownCommand(GameController gameController){
        super(gameController);
    }

    public Void execute(){
        log.log(Level.WARNING, "Unknown command!");
        return null;
    }
}

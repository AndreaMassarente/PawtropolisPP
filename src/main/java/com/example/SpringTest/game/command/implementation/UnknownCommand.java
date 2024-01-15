package com.example.SpringTest.game.command.implementation;


import com.example.SpringTest.game.command.Command;
import com.example.SpringTest.game.controller.GameController;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

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

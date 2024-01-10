package game.command.implementation;

import game.command.Command;
import game.controller.CommandFactory;
import game.controller.GameController;
import lombok.extern.java.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

@Log
public class UnknownCommand extends Command {
    public UnknownCommand(GameController gameController){
        super(gameController);
    }

    public Void execute(){
        log.log(Level.WARNING, "Unknown command!");
        return null;
    }
}

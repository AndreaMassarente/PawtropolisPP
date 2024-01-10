package game.command.implementation;

import game.command.Command;
import game.controller.CommandFactory;
import game.controller.GameController;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UnknownCommand extends Command {
    public UnknownCommand(CommandFactory commandFactory){
        super(commandFactory);
    }

    public Void execute(){
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.WARNING, "Unknown command!");
        return null;
    }
}

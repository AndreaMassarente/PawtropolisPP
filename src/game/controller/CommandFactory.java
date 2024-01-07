package game.controller;

import game.model.Player;
import game.command.Command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandFactory {
    private final Player player;
    private final MapController mapController;

    private final Logger logger = Logger.getLogger(getClass().getName());

    public CommandFactory(Player player) {
        this.player = player;
        mapController = new MapController();
        mapController.generateMap();
    }

    public Object getInstance(List<String> command) {
        String msg = "";
        try {
            String className = "game.command.implementation." + command.getFirst().substring(0, 1).toUpperCase() + command.getFirst().substring(1);

            Class<? extends Command> commandClass = (Class<? extends Command>) Class.forName(className);

            Class<?>[] parameter = {CommandFactory.class};

            return commandClass.getConstructor(parameter).newInstance(this);

        } catch (ClassNotFoundException | NoSuchMethodException exception) {
            logger.log(Level.WARNING, "command not found");
        }catch (InstantiationException | IllegalAccessException | InvocationTargetException exception){
            logger.log(Level.WARNING, "Command not yet implemented");
        }
        return msg;
    }

    public Player getPlayer() {
        return player;
    }

    public MapController getMapController() {
        return mapController;
    }
}

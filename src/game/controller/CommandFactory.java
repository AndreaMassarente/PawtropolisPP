package game.controller;

import game.command.ParametrizedCommand;
import game.command.implementation.UnknownCommand;
import game.model.Player;
import game.command.Command;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
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
        try {
            String className = "game.command.implementation." + command.getFirst().substring(0, 1).toUpperCase() + command.getFirst().substring(1);

            Class<? extends Command> commandClass = (Class<? extends Command>) Class.forName(className);

            Class<?>[] parameter = {CommandFactory.class};

            Object commandInstance =  commandClass.getConstructor(parameter).newInstance(this);

            if(commandInstance instanceof ParametrizedCommand){
                command.removeFirst();
                ((ParametrizedCommand<?>) commandInstance).setParameter(command);
            }
            return commandInstance;

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException exception) {
            return new UnknownCommand(this);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public MapController getMapController() {
        return mapController;
    }
}

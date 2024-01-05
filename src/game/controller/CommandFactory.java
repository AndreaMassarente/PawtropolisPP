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

    public String executeCommandWithoutParameter(String command) {
        String msg = "";
        try {
            String className = "game.command.implementation." + command.substring(0, 1).toUpperCase() + command.substring(1);

            Class<? extends Command> commandClass = (Class<? extends Command>) Class.forName(className);

            Class<?>[] parameter = {CommandFactory.class};

            Method commandMethod = commandClass.getMethod("execute");

            Object commandInstance = commandClass.getConstructor(parameter).newInstance(this);

            msg = (String) commandMethod.invoke(commandInstance);

        } catch (ClassNotFoundException | NoSuchMethodException exception) {
            logger.log(Level.WARNING, "command not found");
        }catch (InstantiationException | IllegalAccessException | InvocationTargetException exception){
            logger.log(Level.WARNING, "Command not yet implemented");
        }
        return msg;
    }

    public String executeCommandWithParameter(List<String> listOfString){
        String msg = "";
        try {
            String className = "game.command.with_parameter.implementation." + listOfString.getFirst().substring(0, 1).toUpperCase() + listOfString.getFirst().substring(1);

            Class<?> commandClass = Class.forName(className);

            Class<?>[] parameter = {CommandFactory.class, String.class};

            Method commandMethod = commandClass.getMethod("execute");

            Object commandInstance = commandClass.getConstructor(parameter).newInstance(this, listOfString.get(1));

            msg =  (String) commandMethod.invoke(commandInstance);

        } catch (ClassNotFoundException | NoSuchMethodException exception) {
            logger.log(Level.WARNING, "command not found");
        }catch (InstantiationException | IllegalAccessException | InvocationTargetException exception){
            logger.log(Level.WARNING, "Command not yet implemented");
        }
        return Objects.requireNonNullElse(msg, "");
    }

    public Player getPlayer() {
        return player;
    }

    public MapController getMapController() {
        return mapController;
    }
}

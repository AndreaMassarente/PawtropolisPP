package game.controller;

import game.model.Player;
import game.util.command.Command;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandRunner {
    private final Player player;
    private final MapController mapController;

    private final Logger logger = Logger.getLogger(getClass().getName());

    public CommandRunner(Player player) {
        this.player = player;
        mapController = new MapController();
        mapController.generateMap();
    }

    public String executeCommandWithoutParameter(String command) {
        String msg = "";
        try {
            String className = "game.util.command.implementation." + command.substring(0, 1).toUpperCase() + command.substring(1);

            Class<? extends Command> commandClass = (Class<? extends Command>) Class.forName(className);

            Class<?>[] parameter = {CommandRunner.class};

            Method commandMethod = commandClass.getMethod("execute");

            Object commandInstance = commandClass.getConstructor(parameter).newInstance(this);

            msg = (String) commandMethod.invoke(commandInstance);

        } catch (Exception e) {
            logger.log(Level.WARNING, "command not found");
        }
        return msg;
    }

    public String executeCommandWithParameter(List<String> listOfString){
        String msg = "";
        try {
            String className = "game.util.command.with_parameter.implementation." + listOfString.get(0).substring(0, 1).toUpperCase() + listOfString.get(0).substring(1);

            Class<?> commandClass = Class.forName(className);

            Class<?>[] parameter = {CommandRunner.class, String.class};

            Method commandMethod = commandClass.getMethod("execute");

            Object commandInstance = commandClass.getConstructor(parameter).newInstance(this, listOfString.get(1));

            msg =  (String) commandMethod.invoke(commandInstance);

        } catch (Exception e) {
            logger.log(Level.WARNING, "command not found");
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

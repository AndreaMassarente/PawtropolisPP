package game.util.command;

import game.controller.MapController;
import game.model.Player;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CommandController {
    private final Player player;
    private final MapController mapController;

    public CommandController(Player player) {
        this.player = player;
        mapController = new MapController();
        mapController.generateMap();
    }

    public String executeCommandWithoutParameter(String command) {
        String message = "";
        try {
            String className = "game.util.command." + command.substring(0, 1).toUpperCase() + command.substring(1);

            Class<? extends Command> clazz = (Class<? extends Command>) Class.forName(className);

            Class<?>[] parameter = {CommandController.class};

            Method method = clazz.getMethod("execute");

            Object obj = clazz.getConstructor(parameter).newInstance(this);

            message = (String) method.invoke(obj);

        } catch (Exception e) {
            System.err.println("Command not found");
        }
        return message;
    }

    public String executeCommandWithParameter(List<String> listOfString){
        String message = "";
        try {
            String className = "game.util.command." + listOfString.get(0).substring(0, 1).toUpperCase() + listOfString.get(0).substring(1);

            Class<?> clazz = Class.forName(className);

            Class<?>[] parameter = {CommandController.class, String.class};

            Method method = clazz.getMethod("execute");

            Object obj = clazz.getConstructor(parameter).newInstance(this, listOfString.get(1));

            message =  (String) method.invoke(obj);

        } catch (Exception e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }

        return Objects.requireNonNullElse(message, "");
    }

    public Player getPlayer() {
        return player;
    }

    public MapController getMapController() {
        return mapController;
    }
}

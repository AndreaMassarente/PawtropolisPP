package game.controller;

import game.command.ParametrizedCommand;
import game.command.implementation.UnknownCommand;
import game.command.Command;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Logger;

public class CommandFactory {
    private final GameController gameController;

    public CommandFactory(GameController gameController) {
        this.gameController = gameController;
    }

    public GameController getGameController() {
        return gameController;
    }

    private final Logger logger = Logger.getLogger(getClass().getName());

    public Object getInstance(List<String> command) {
        try {
            String className = "game.command.implementation." + command.getFirst().substring(0, 1).toUpperCase() + command.getFirst().substring(1);

            Class<? extends Command> commandClass = (Class<? extends Command>) Class.forName(className);

            Class<?>[] parameter = {GameController.class};

            Object commandInstance =  commandClass.getConstructor(parameter).newInstance(gameController);

            if(commandInstance instanceof ParametrizedCommand){
                command.removeFirst();
                ((ParametrizedCommand<?>) commandInstance).setParameter(command);
            } else if (command.size() > 1) {
                return new UnknownCommand(gameController);
            }
            return commandInstance;

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException exception) {
            return new UnknownCommand(gameController);
        }
    }
}

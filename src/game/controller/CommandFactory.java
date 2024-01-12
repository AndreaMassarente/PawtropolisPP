package game.controller;

import game.command.ParametrizedCommand;
import game.command.implementation.Get;
import game.command.implementation.Go;
import game.command.implementation.UnknownCommand;
import game.model.Player;
import game.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@AllArgsConstructor
public class CommandFactory {
    private final GameController gameController;

    public Object getInstance(List<String> wordlist) {
        try {
            String className = "game.command.implementation." + wordlist.getFirst().substring(0, 1).toUpperCase() + wordlist.getFirst().substring(1);

            Class<? extends Command> commandClass = (Class<? extends Command>) Class.forName(className);

            Class<?>[] parameter = {GameController.class};

            Object commandInstance =  commandClass.getConstructor(parameter).newInstance(this);

            if(commandInstance instanceof ParametrizedCommand){
                wordlist.removeFirst();
                ((ParametrizedCommand<?>) commandInstance).setParameter(wordlist);
            }else if (wordlist.size() > 1) {
                return new UnknownCommand(gameController);
            }
            return commandInstance;

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException exception) {
            return new UnknownCommand(gameController);
        }
    }
}

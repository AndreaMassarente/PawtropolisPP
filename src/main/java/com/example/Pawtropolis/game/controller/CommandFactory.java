package com.example.Pawtropolis.game.controller;


import com.example.Pawtropolis.game.command.Command;
import com.example.Pawtropolis.game.command.ParametrizedCommand;
import com.example.Pawtropolis.game.command.implementation.UnknownCommand;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;


import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Getter
@Configuration
public class CommandFactory {
    private final GameController gameController;

    public CommandFactory(GameController gameController) {
        this.gameController = gameController;
    }

    public Object getInstance(List<String> wordlist) {
        try {
            String className = "com.example.SpringTest.game.command.implementation." + wordlist.getFirst().substring(0, 1).toUpperCase() + wordlist.getFirst().substring(1) +"Command";

            Class<? extends Command> commandClass = (Class<? extends Command>) Class.forName(className);

            Class<?>[] parameter = {GameController.class};

            Object commandInstance =  commandClass.getConstructor(parameter).newInstance(gameController);

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

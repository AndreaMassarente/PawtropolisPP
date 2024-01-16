package com.example.Pawtropolis.game.service;

import com.example.Pawtropolis.game.command.ParametrizedCommand;
import com.example.Pawtropolis.game.command.implementation.UnknownCommand;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Configuration
public class CommandFactory{
    private final ApplicationContext context;
    public CommandFactory(ApplicationContext context) {
        this.context = context;
    }

    public Object getInstance(List<String> wordList) {
        try {
            Object commandInstance = this.context.getBean(wordList.getFirst() + "Command");
            if (commandInstance instanceof ParametrizedCommand) {
                wordList.removeFirst();
                ((ParametrizedCommand<?>) commandInstance).setParameter(wordList);
            } else if (wordList.size() > 1) {
                return this.context.getBean(UnknownCommand.class);
            }
            return commandInstance;
        }
        catch (NoSuchBeanDefinitionException e) {
            return this.context.getBean(UnknownCommand.class);
        }
    }
}
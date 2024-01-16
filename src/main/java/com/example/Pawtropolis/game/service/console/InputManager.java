package com.example.Pawtropolis.game.service.console;

import com.example.Pawtropolis.game.command.Command;
import com.example.Pawtropolis.game.service.CommandFactory;
import lombok.NonNull;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class InputManager {
    private final CommandFactory commandFactory;
    public InputManager(@Lazy CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public String readCommand(String input){
        List<String> wordList;
        String returnString;
        String lowerCaseString = input.trim().toLowerCase();

        if (lowerCaseString.isEmpty()){
            returnString = "You must enter a command";
        } else {
            wordList = splitWords(lowerCaseString);
            Command currentCommand = (Command) commandFactory.getInstance(wordList);
            returnString = (String) currentCommand.execute();
        }
        return Objects.requireNonNullElse(returnString, "");
    }

    private List<String> splitWords(String input){
        String delimiters = "[ \t,.:;?!\"']+";
        String[] words = input.split(delimiters, 2);

        return new ArrayList<>(Arrays.asList(words));
    }
}

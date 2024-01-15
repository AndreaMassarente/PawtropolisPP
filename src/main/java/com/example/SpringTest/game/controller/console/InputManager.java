package com.example.SpringTest.game.controller.console;


import com.example.SpringTest.game.command.Command;
import com.example.SpringTest.game.controller.CommandFactory;
import com.example.SpringTest.game.controller.GameController;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class InputManager {

    private final CommandFactory commandFactory;
    public InputManager(@Lazy GameController gameController) {
        commandFactory = new CommandFactory(gameController);
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
        if(returnString != null)
            return returnString;
        else
            return "";
    }

    private List<String> splitWords(String input){
        String delimiters = "[ \t,.:;?!\"']+";
        String[] words = input.split(delimiters, 2);

        return new ArrayList<>(Arrays.asList(words));
    }
}

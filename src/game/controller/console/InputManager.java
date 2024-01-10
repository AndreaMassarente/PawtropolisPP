package game.controller.console;

import game.command.Command;
import game.model.Player;
import game.controller.CommandFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {
    private final CommandFactory commandFactory;
    public InputManager(Player player) {
        commandFactory = new CommandFactory(player);
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

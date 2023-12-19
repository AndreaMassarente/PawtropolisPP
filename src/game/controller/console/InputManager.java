package game.controller.console;

import game.model.Player;
import game.controller.CommandRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {
    private final CommandRunner commandRunner;
    public InputManager(Player player) {
        commandRunner = new CommandRunner(player);
    }

    public String readCommand(String input){
        List<String> wordList;
        String returnString;
        String lowerCaseString = input.trim().toLowerCase();

        if(!lowerCaseString.equals("q")){
            if (lowerCaseString.isEmpty()){
                returnString = "You must enter a command";
            } else {
                wordList = splitWords(lowerCaseString);
                returnString = parseCommand(wordList);
            }
        }
        else
            return "quit";
        return returnString;
    }

    private List<String> splitWords(String input){
        String delimiters = "[ \t,.:;?!\"']+";
        String[] words = input.split(delimiters, 2);

        return new ArrayList<>(Arrays.asList(words));
    }

    private String parseCommand(List<String> wordList){
        String msg;
        if(wordList.size() == 1){
            msg = commandRunner.executeCommandWithoutParameter(wordList.get(0));
        } else if (wordList.size() > 1) {
            msg = commandRunner.executeCommandWithParameter(wordList);
        } else {
            msg = "Command not allowed!";
        }
        return msg;
    }
}

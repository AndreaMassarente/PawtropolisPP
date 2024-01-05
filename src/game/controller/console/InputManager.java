package game.controller.console;

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
            returnString = parseCommand(wordList);
        }
        return returnString;
    }

    private List<String> splitWords(String input){
        String delimiters = "[ \t,.:;?!\"']+";
        String[] words = input.split(delimiters, 2);

        return new ArrayList<>(Arrays.asList(words));
    }

    private String parseCommand(List<String> wordList){ //Cambia nome, spostare questo controllo nei comandi stessi
        String msg;
        if(wordList.size() == 1){
            msg = commandFactory.executeCommandWithoutParameter(wordList.getFirst());
        } else if (wordList.size() > 1) {
            msg = commandFactory.executeCommandWithParameter(wordList);
        } else {
            msg = "Command not allowed!";
        }
        return msg;
    }
}

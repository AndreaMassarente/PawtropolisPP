package game.controllers.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputController {
    public InputController() {
    }

    public String readCommand(String input){
        List<String> wordList;
        String returnString = "";
        String lowerCaseString = input.trim().toLowerCase();

        if(!lowerCaseString.equals("q")){
            if (lowerCaseString.isEmpty()){
                returnString = "You must enter a command";
            } else {
                wordList = splitWords(lowerCaseString);
                //returnString = parseCommand(wordList);
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


}

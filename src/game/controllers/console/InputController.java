package game.controllers.console;

import util.CommandEnum;
import util.DirectionEnum;
import util.ItemEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputController {
    private final CommandController commandController;
    public InputController() {
        commandController = new CommandController();
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

    public String parseCommand(List<String> wordList){
        String msg;
        if(wordList.size() == 1){
            msg = runCommandWithoutParameter(wordList);
        } else if (wordList.size() > 1) {
            msg = runCommandWithParameter(wordList);
        } else {
            msg = "Command not allowed!";
        }
        return msg;
    }

    public String runCommandWithoutParameter(List<String> wordlist){
        String msg = "";
        CommandEnum command = CommandEnum.getCommandFromInput(wordlist.get(0));

        if(command == null){
            msg = "incorrect command";
        } else {
            switch (command){
                case LOOK:
                    return commandController.look();
                case BAG:
                    return commandController.bag();
                default:
                    msg = command + " not yet implemented";
                    break;
            }
        }
        return msg;
    }

    public String runCommandWithParameter(List<String> wordList){
        String parameterName;
        String msg = "";
        boolean error = false;

        parameterName = wordList.get(1);
        CommandEnum command = CommandEnum.getCommandFromInput(wordList.get(0));
        ItemEnum item = ItemEnum.getItemFromInput(parameterName);
        DirectionEnum direction = DirectionEnum.getDirectionFromInput(parameterName);

        if(command == null) {
            msg = "incorrect command!";
            error = true;
        }
        if(!error) {
            switch (command){
                case GO:
                    if (direction == null) {
                        return "parameter " + parameterName + " is not a direction";
                    }
                    return commandController.go(parameterName);
                case GET:
                    if(item == null){
                        return parameterName + " is not a correct parameter!";
                    }
                    commandController.getItem(parameterName);
                    break;
                case DROP:
                    if(item == null){
                        return parameterName + " is not a correct parameter!";
                    }
                    commandController.dropItem(parameterName);
                    break;
                default:
                    msg = command + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }
}

package game.controllers.console;

import game.controllers.MapController;
import game.model.Item;
import game.model.Player;
import utils.CommandEnum;
import utils.DirectionEnum;
import utils.ItemEnum;

import java.util.List;
import java.util.logging.Logger;

public class CommandController {
    private final Player player;
    private final MapController mapController;
    public CommandController(Player player) {
        this.player = player;
        mapController = new MapController();
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
                    return mapController.getCurrentRoom().getRoomDescription();
                case BAG:
                    return player.getMyBag().getItemsInBag();
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
                    return mapController.changeCurrentRoom(parameterName);
                case GET:
                    if(item == null){
                        return parameterName + " is not a correct parameter!";
                    }
                    getItem(parameterName);
                    break;
                case DROP:
                    if(item == null){
                        return parameterName + " is not a correct parameter!";
                    }
                    dropItem(parameterName);
                    break;
                default:
                    msg = command + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    public void getItem(String itemName) {
        Item item = mapController.getCurrentRoom().getItemFromInput(itemName);
        Logger logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.info("no " + itemName + " in room");
        } else if (!player.getMyBag().addItemInBag(item)) {
            logger.info("no enough space in bag");
        } else {
            mapController.getCurrentRoom().removeItem(item);
        }
    }

    public void dropItem(String itemName) {
        Item item = player.getMyBag().getItemFromInput(itemName);
        Logger logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.info("no" + itemName + " in bag");
        } else  {
            player.getMyBag().removeItemFromBag(item);
            mapController.getCurrentRoom().addItem(item);
        }
    }
}

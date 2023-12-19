package game.util.command;

import game.model.Item;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Drop extends Command{
    private final CommandController commandController;
    private final String itemName;
    public Drop(CommandController commandController, String itemName){
        this.commandController = commandController;
        this.itemName = itemName;
    }

    public Void execute(){
        Item item = commandController.getPlayer().getBag().getItemByString(itemName);
        Logger logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.log(Level.WARNING, "no {0} in bag", itemName);
        } else  {
            commandController.getPlayer().getBag().removeItem(item);
            commandController.getMapController().getCurrentRoom().addItem(item);
        }
        return null;
    }

}

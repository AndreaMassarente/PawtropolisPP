package game.util.command;

import game.model.Item;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Get extends Command{
    private final CommandController commandController;
    private final String itemName;
    public Get(CommandController commandController, String itemName){
        this.commandController = commandController;
        this.itemName = itemName;
    }

    @Override
    public Void execute() {
        Item item = commandController.getMapController().getCurrentRoom().getItemByString(itemName);
        Logger logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.log(Level.WARNING,"no {0} in room", itemName);
        } else if (!commandController.getPlayer().getBag().addItem(item)) {
            logger.info("no enough space in bag");
        } else {
            commandController.getMapController().getCurrentRoom().removeItem(item);
        }
        return null;
    }
}

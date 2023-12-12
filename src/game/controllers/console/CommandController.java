package game.controllers.console;

import game.controllers.MapController;
import game.model.Item;
import game.model.Player;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandController {
    private final Player player;
    private final MapController mapController;
    private Logger logger;
    public CommandController() {
        player = new Player();
        mapController = new MapController();
    }

    public String look() {
        return mapController.getCurrentRoom().getRoomDescription();
    }

    public String bag() {
        return player.getMyBag().getItemsInBag();
    }

    public String go(String direction) {
        return mapController.changeCurrentRoom(direction);
    }

    public void getItem(String itemName) {
        Item item = mapController.getCurrentRoom().getItemFromInput(itemName);
        logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.log(Level.INFO, "no {0} in room", itemName);
        } else if (!player.getMyBag().addItemInBag(item)) {
            logger.info("no enough space in bag");
        } else {
            mapController.getCurrentRoom().removeItem(item);
        }
    }

    public void dropItem(String itemName) {
        Item item = player.getMyBag().getItemFromInput(itemName);
        logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.log(Level.INFO, "no {0} in bag", itemName);
        } else  {
            player.getMyBag().removeItemFromBag(item);
            mapController.getCurrentRoom().addItem(item);
        }
    }
}

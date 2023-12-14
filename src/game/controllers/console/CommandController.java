package game.controllers.console;

import game.controllers.MapController;
import game.model.Item;
import game.model.Player;
import java.util.logging.Logger;

public class CommandController {
    private final Player player;
    private final MapController mapController;
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
        Item item = mapController.getCurrentRoom().getItemInRoomFromInput(itemName);
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
        Item item = player.getMyBag().getItemInBagFromInput(itemName);
        Logger logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.info("no" + itemName + " in bag");
        } else  {
            player.getMyBag().removeItemFromBag(item);
            mapController.getCurrentRoom().addItem(item);
        }
    }
}

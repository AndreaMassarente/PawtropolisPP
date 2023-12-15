package game.controller;

import game.model.Item;
import game.model.Player;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandController {
    private final Player player;
    private final MapController mapController;
    public CommandController() {
        player = new Player();
        mapController = new MapController();
    }

    public String look() {
        return mapController.getCurrentRoom().look();
    }

    public String bag() {
        return player.getBag().getItemsToString();
    }

    public String go(String direction) {
        return mapController.changeCurrentRoom(direction);
    }

    public void getItem(String itemName) {
        Item item = mapController.getCurrentRoom().getItemByString(itemName);
        Logger logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.log(Level.WARNING,"no {0} in room", itemName);
        } else if (!player.getBag().addItem(item)) {
            logger.info("no enough space in bag");
        } else {
            mapController.getCurrentRoom().removeItem(item);
        }
    }

    public void dropItem(String itemName) {
        Item item = player.getBag().getItemByString(itemName);
        Logger logger = Logger.getLogger(getClass().getName());
        if (item == null) {
            logger.log(Level.WARNING, "no {0} in bag", itemName);
        } else  {
            player.getBag().removeItem(item);
            mapController.getCurrentRoom().addItem(item);
        }
    }
}

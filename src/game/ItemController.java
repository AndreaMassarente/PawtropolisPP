package game;

import game.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemController {
    private List<Item> items;

    public ItemController() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public List<Item> getItems() {
        return items;
    }
}

package game;

import game.model.Item;

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

    public void generateItems(){
        items.add(new Item("Potion", "Heals 20 HP", 1));
        items.add(new Item("Super Potion", "Heals 50 HP", 1));
        items.add(new Item("Hyper Potion", "Heals 200 HP", 2));
        items.add(new Item("Full Heal", "Heals all status conditions", 1));
        items.add(new Item("Full Restore", "Heals all HP and status conditions", 2));
        items.add(new Item("Sword", "+10 atk", 1));
        items.add(new Item("Shield", "+10 def", 1));
        items.add(new Item("Armor", "+50 def, -20 speed", 2));
        items.add(new Item("Bow", "+10 sp.atk, +10speed", 1));
        items.add(new Item("Gun", "+20 sp.atk, +20 sp.def", 2));
    }
}

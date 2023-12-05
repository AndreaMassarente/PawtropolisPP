package game.domain;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final int maxSlots;
    private int currentFreeSlots;
    private List<Item> items;

    public Bag() {
        this.maxSlots = 6;
        this.currentFreeSlots = maxSlots;
        this.items = new ArrayList<>();
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public int getCurrentFreeSlots() {
        return currentFreeSlots;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setCurrentFreeSlots(int currentFreeSlots) {
        this.currentFreeSlots = currentFreeSlots;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

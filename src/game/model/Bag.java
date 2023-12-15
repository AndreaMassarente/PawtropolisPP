package game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public String getItemsInBag(){
        if(!items.isEmpty()){
            String msg = items.stream()
                    .map(i -> i.getName() +", ")
                    .collect(Collectors.joining());
            return msg.substring(0, msg.length() - 2) + "\n" + currentFreeSlots + " slots remaining" ;
        }
        else
            return "No items in bag";
    }

    public boolean addItemInBag(Item item){
        if(item.getSpaceInBag() <= currentFreeSlots){
            items.add(item);
            currentFreeSlots -= item.getSpaceInBag();
            return true;
        }
        else{
            return false;
        }
    }

    public void removeItemFromBag(Item item){
        items.remove(item);
        currentFreeSlots += item.getSpaceInBag();
    }

    public Item getItemInBagFromInput(String input) {
        String nameToLowerCase = input.trim().toLowerCase();
        return items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(nameToLowerCase))
                .findAny()
                .orElse(null);
    }
}

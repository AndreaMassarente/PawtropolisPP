package game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private final int maxSlots;
    private int currentFreeSlots;

    private final List<Item> items;


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

    public void setCurrentFreeSlots(int currentFreeSlots) {
        this.currentFreeSlots = currentFreeSlots;
    }


    public String getItemsToString(){
        if(!items.isEmpty()){
            String msg = items.stream()
                    .map(i -> i.getName() +", ")
                    .collect(Collectors.joining());
            return msg.substring(0, msg.length() - 2) + "\n" + currentFreeSlots + " slots remaining" ;
        }
        else
            return "No items in bag";
    }

    public boolean addItem(Item item){
        if(item.getRequiredSpace() <= currentFreeSlots){
            items.add(item);
            currentFreeSlots -= item.getRequiredSpace();
            return true;
        }
        else{
            return false;
        }
    }

    public void removeItem(Item item){
        if(items.contains(item)){
            items.remove(item);
            currentFreeSlots += item.getRequiredSpace();
        }
    }

    public Item getItemByString(String string) {
        String name = string.trim();
        return items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }
}

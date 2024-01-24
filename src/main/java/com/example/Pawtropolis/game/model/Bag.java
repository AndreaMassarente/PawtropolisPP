package com.example.Pawtropolis.game.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    @Getter
    private final int maxSlots;
    @Getter
    @Setter
    private int currentFreeSlots;

    private final List<Item> items;

    public Bag() {
        this.maxSlots = 6;
        this.currentFreeSlots = maxSlots;
        this.items = new ArrayList<>();
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

    public boolean isPresent(String itemName) {
        return items.stream()
                .anyMatch(item -> item.getName().equalsIgnoreCase(itemName));
    }
}

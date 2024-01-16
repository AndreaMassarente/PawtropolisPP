package com.example.Pawtropolis.game.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Player {
    @Setter
    @Getter
    private String name;
    @Getter
    @Setter
    private int healthPoints;
    private final Bag bag;

    @Autowired
    public Player(Bag bag){
        this.bag = bag;
        healthPoints = 10;
    }

    public boolean addItemInBag(Item item){
        return bag.addItem(item);
    }

    public void removeItemFromBag(Item item){
        bag.removeItem(item);
    }

    public String geItemsInBag(){
        return bag.getItemsToString();
    }

    public Item getItemInBagByString(String string){
        return bag.getItemByString(string);
    }
}
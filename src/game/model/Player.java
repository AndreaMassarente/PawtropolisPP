package game.model;

import lombok.Getter;
import lombok.Setter;

public class Player {
    @Getter
    private final String name;
    @Getter
    @Setter
    private int healthPoints;
    private final Bag bag;

    public Player(String name) {
        this.name = name;
        healthPoints = 10;
        bag = new Bag();
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

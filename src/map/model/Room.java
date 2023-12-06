package map.model;

import animals.model.Animal;
import game.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String name;
    private final String description;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
    private List<Item> items;
    private List<Animal> npc;

    public Room(String name, String description, Room north, Room south, Room west, Room east) {
        this.name = name;
        this.description = description;
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
        items = new ArrayList<>();
        npc = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    public Room getEast() {
        return east;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Animal> getNpc() {
        return npc;
    }

    public void setNpc(List<Animal> npc) {
        this.npc = npc;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){ items.remove(item);}

    public void addNpc(Animal npc){
        this.npc.add(npc);
    }

    public String getRoomDescription(){
        String npcDescription = new String();
        String itemsDescription = new String();

        for (Animal animal: npc){
            npcDescription += animal.getName() + ", " + animal.getClass().getSimpleName() + "\n";
        }

        for (Item item: items){
            itemsDescription += item.getName() +"\n";
        }

        return "You are in " + getName() +  "\n" + getDescription() + "\nItems:\n" + itemsDescription
                +"\nNCP:\n" + npcDescription + "\n";

    }

    public String getItemInRoom(){
        String itemsDescription = new String();
        for (Item item: items){
            itemsDescription += item.getName() +"\n";
        }
        return itemsDescription;
    }
}

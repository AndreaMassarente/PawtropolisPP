package map.model;

import animals.model.Animal;
import game.model.Item;
import map.utils.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Room {
    private final String name;
    private final String description;

    private final Map<Direction, Room> connectedRooms;
    private final List<Item> items;
    private final List<Animal> npc;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        connectedRooms = new HashMap<>();
        items = new ArrayList<>();
        npc = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public Map<Direction, Room> getConnectedRooms() {
        return connectedRooms;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Animal> getNpc() {
        return npc;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){ items.remove(item);}

    public void addNpc(Animal npc){
        this.npc.add(npc);
    }

    public void removeNpc(Animal npc) {
        this.npc.remove(npc);
    }

    public String getRoomDescription(){
        String npcDescription;
        String itemsDescription;

        if(!npc.isEmpty()){
            npcDescription = npc.stream()
                    .map(a -> a.getName() + "(" + a.getClass().getSimpleName() +"), ")
                    .collect(Collectors.joining());
            npcDescription = npcDescription.substring(0,npcDescription.length() - 2);
        }
        else {
            npcDescription = "No Npc in this room";
        }

        if(!items.isEmpty()){
            itemsDescription = items.stream()
                    .map(i -> i.getName() +", ")
                    .collect(Collectors.joining());
            itemsDescription = itemsDescription.substring(0, itemsDescription.length() - 2);
        }
        else {
            itemsDescription = "No items in this room";
        }

        return "You are in " + getName() +  "\n" + getDescription() + "\nItems:\n" + itemsDescription
                +"\nNCP:\n" + npcDescription + "\n";

    }

    public void addConnectedRoom(Direction direction, Room room){
        connectedRooms.put(direction, room);
    }

    public String getItemInRoom(){
        String itemsDescription;

        if(!items.isEmpty()){
            itemsDescription = items.stream()
                    .map(i -> i.getName() +", ")
                    .collect(Collectors.joining());
            return itemsDescription.substring(0, itemsDescription.length() - 2);
        }
        else {
            return  "No items in this room";
        }
    }
}

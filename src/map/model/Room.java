package map.domain;

import animals.domain.Animal;
import game.domain.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Room {
    private final int id;
    private final String name;
    private final String description;
    private final int n;
    private final int s;
    private final int w;
    private final int e;
    private List<Item> items;
    private List<Animal> npc;

    public Room(int id, String name, String description, int n, int s, int w, int e) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.n = n;
        this.s = s;
        this.w = w;
        this.e = e;
        items = new ArrayList<>();
        npc = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getN() {
        return n;
    }

    public int getS() {
        return s;
    }

    public int getW() {
        return w;
    }

    public int getE() {
        return e;
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

        return "You are in Room " + getId() +  "\n" + getDescription() + "\nItems:\n" + itemsDescription
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

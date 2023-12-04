package map.domain;

import animals.domain.Animal;
import game.domain.Item;

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

    public void addNpc(Animal npc){
        this.npc.add(npc);
    }
}

package game.model;

public class Player {
    private final String name;
    private int healthPoints;
    private final Bag bag;

    public Player(String name) {
        this.name = name;
        healthPoints = 10;
        bag = new Bag();
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Bag getBag() {
        return bag;
    }

    public boolean addItemInBag(Item item){
        return bag.addItem(item);
    }
}

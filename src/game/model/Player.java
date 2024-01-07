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

    public boolean addItemInBag(Item item){
        return bag.addItem(item);
    }

    public void removeItemFromBag(Item item){
        bag.removeItem(item);
    }

    public String getElementInBag(){
        return bag.getItemsToString();
    }

    public Item getItemInBagByString(String string){
        return bag.getItemByString(string);
    }
}

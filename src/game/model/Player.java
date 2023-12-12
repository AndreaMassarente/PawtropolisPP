package game.model;

public class Player {
    private final String name;
    private int healthPoints;
    private final Bag myBag;

    public Player(String name) {
        this.name = name;
        healthPoints = 10;
        myBag = new Bag();
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

    public Bag getMyBag() {
        return myBag;
    }
}

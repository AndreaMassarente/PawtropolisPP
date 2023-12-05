package game.domain;

public class Player {
    private final String name;
    private int healthPoints;
    private Bag myBag;

    public Player(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
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
}

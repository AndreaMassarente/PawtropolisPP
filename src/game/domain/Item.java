package game.domain;

public class Item {
    private final String name;
    private final String description;
    private final int spaceInBag;

    public Item(String name, String description, int spaceInBag) {
        this.name = name;
        this.description = description;
        this.spaceInBag = spaceInBag;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getSpaceInBag() {
        return spaceInBag;
    }
}

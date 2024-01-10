package game.model;

import java.util.Arrays;

public enum Direction {
    NORTH ("North"),
    SOUTH ("South"),
    EAST ("East"),
    WEST ("West");

    private final String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Direction getDirectionByString(String string){
        return Arrays.stream(Direction.values())
                .filter(d -> d.name.equalsIgnoreCase(string))
                .findFirst()
                .orElse(null);
    }
}

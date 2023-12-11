package map.utils;

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

    public static Direction getDirection(String s){
        return Arrays.stream(Direction.values())
                .filter(d -> d.name.equalsIgnoreCase(s))
                .findFirst()
                .orElse(null);
    }
}

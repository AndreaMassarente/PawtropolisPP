package utils;

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

    public static Direction getDirectionFromInput(String input){
        return Arrays.stream(Direction.values())
                .filter(d -> d.name.equalsIgnoreCase(input))
                .findFirst()
                .orElse(null);
    }
}

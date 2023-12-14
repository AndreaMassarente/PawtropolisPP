package util;

import java.util.Arrays;

public enum DirectionEnum {
    NORTH ("North"),
    SOUTH ("South"),
    EAST ("East"),
    WEST ("West");

    private final String name;

    DirectionEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static DirectionEnum getDirectionFromInput(String input){
        return Arrays.stream(DirectionEnum.values())
                .filter(d -> d.name.equalsIgnoreCase(input))
                .findFirst()
                .orElse(null);
    }
}

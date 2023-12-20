package game.util.enu;

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

    public static DirectionEnum getDirectionByString(String string){
        return Arrays.stream(DirectionEnum.values())
                .filter(d -> d.name.equalsIgnoreCase(string))
                .findFirst()
                .orElse(null);
    }
}

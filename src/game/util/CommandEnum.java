package game.util;

import java.util.Arrays;

public enum CommandEnum {
    LOOK("Look"),
    BAG("Bag"),
    GO("Go"),
    GET("Get"),
    DROP("Drop");

    private final String name;

    CommandEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CommandEnum getCommandByString(String string){
        return Arrays.stream(CommandEnum.values())
                .filter(c -> c.name.equalsIgnoreCase(string))
                .findFirst()
                .orElse(null);
    }
}

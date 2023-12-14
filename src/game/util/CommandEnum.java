package game.util;

import java.util.Arrays;

public enum CommandEnum {
    LOOK("look"),
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

    public static CommandEnum getCommandFromInput(String input){
        return Arrays.stream(CommandEnum.values())
                .filter(c -> c.name.equalsIgnoreCase(input))
                .findFirst()
                .orElse(null);
    }
}

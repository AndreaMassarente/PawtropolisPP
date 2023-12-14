package util;

import java.util.Arrays;

public enum ItemEnum {
    POTION("Potion"),
    SUPERPOTION("Super Potion"),
    HYPERPOTION("Hyper Potion"),
    FULLHEAL("Full Heal"),
    FULLRESTORE("Full Restore"),
    SWORD("Sword"),
    SHIELD("Shield"),
    ARMOR("Armor"),
    BOW("Bow"),
    GUN("Gun");

    private final String name;

    ItemEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ItemEnum getItemFromInput(String input){
        return Arrays.stream(ItemEnum.values())
                .filter(i -> i.name.equalsIgnoreCase(input))
                .findFirst()
                .orElse(null);
    }
}

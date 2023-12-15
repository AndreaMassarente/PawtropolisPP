package game.util;

import java.util.Arrays;

public enum ItemEnum {
    POTION("Potion"),
    SUPER_POTION("Super Potion"),
    HYPER_POTION("Hyper Potion"),
    FULL_HEAL("Full Heal"),
    FULL_RESTORE("Full Restore"),
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

    public static ItemEnum getItemByString(String string){
        return Arrays.stream(ItemEnum.values())
                .filter(i -> i.name.equalsIgnoreCase(string))
                .findFirst()
                .orElse(null);
    }
}

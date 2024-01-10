package game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {
    //bug fixed
    private final String name;
    private final String description;
    private final int requiredSpace;
}

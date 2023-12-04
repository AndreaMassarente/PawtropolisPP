package map;

import map.domain.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapController {
    private final Map<Integer, Room> map;

    public MapController(){
        map = generateMap();
    }

    public Map<Integer, Room> generateMap(){
        Map<Integer, Room> map = new HashMap<>();
        map.put(1,new Room(1, "Basement", "You’re in a dark, cramped place", 0, 2, 3, 6));
        map.put(2,new Room(2, "Thermal Baths", "You are in a warm place, there is a lot of fog and hot water gaiser", 1, 0, 0, 0));
        map.put(3,new Room(3, "Cave", "You’re in a dark cave, you hear a lot of chilling noises", 4, 0, 5, 1));
        map.put(4,new Room(4, "Mausoleum", "", 0, 0, 0, 3));
        map.put(5,new Room(5, "Temple", "You are in an old temple, the stones are worn, there is moss everywhere, torches illuminate a flight of steps leading to a throne", 0, 0, 0, 3));
        map.put(6,new Room(6, "Downpour", "You ended up in a sewer, you're soaked in dirty water", 0, 0, 1, 7));
        map.put(7,new Room(7, "Mines", "You're in a mine, you see hundreds of sparkles in the dark", 0, 0, 6, 0));
        map.put(8,new Room(8, "Jungle", "You catch a glimpse of dense vegetation, it is pouring rain, and there is a herd of monkeys watching you", 9, 6, 0, 0));
        map.put(9,new Room(9, "Desert", "You ended up in a desert, the air is hot and the place seems hostile", 0, 8, 0, 10));
        map.put(10,new Room(10, "Mountain", "You are on the top of a very high mountain, there is snow everywhere, the air is fresh", 0, 0, 9, 11));
        map.put(11,new Room(11, "Treasure Room", "You've never seen so much wealth in one place", 0, 12, 10, 0));
        map.put(12,new Room(12, "Boos Room", "This place is unlike any you have encountered, the calmness that seems to be there snows you", 11,0, 0, 0));
    }

}

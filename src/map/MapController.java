package map;

import animals.ZooController;
import animals.domain.Animal;
import animals.domain.AnimalNotFound;
import game.ItemController;
import game.domain.Item;
import map.domain.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapController {
    private final Map<Integer, Room> map;
    private Room currentRoom;

    public MapController(){
        map = generateMap();
        currentRoom = map.get(1);
    }


    public Map<Integer, Room> generateMap(){
        Map<Integer, Room> map1 = new HashMap<>();

        //Creazine delle stanze
        Room room1 = new Room(1, "Basement", "You’re in a dark, cramped place", 0, 2, 3, 6);
        Room room2 = new Room(2, "Thermal Baths", "You are in a warm place, there is a lot of fog and hot water gaiser", 1, 0, 0, 0);
        Room room3 = new Room(3, "Cave", "You’re in a dark cave, you hear a lot of chilling noises", 4, 0, 5, 1);
        Room room4 = new Room(4, "Mausoleum", "You’re in front of a grave, but it’s too big to be a normal person", 0, 3, 0, 0);
        Room room5 = new Room(5, "Temple", "You are in an old temple, the stones are worn, there is moss everywhere, torches illuminate a flight of steps leading to a throne", 0, 0, 0, 3);
        Room room6 = new Room(6, "Downpour", "You ended up in a sewer, you're soaked in dirty water", 8, 0, 1, 7);
        Room room7 = new Room(7, "Mines", "You're in a mine, you see hundreds of sparkles in the dark", 0, 0, 6, 0);
        Room room8 = new Room(8, "Jungle", "You catch a glimpse of dense vegetation, it is pouring rain, and there is a herd of monkeys watching you", 9, 6, 0, 0);
        Room room9 = new Room(9, "Desert", "You ended up in a desert, the air is hot and the place seems hostile", 0, 8, 0, 10);
        Room room10 = new Room(10, "Mountain", "You are on the top of a very high mountain, there is snow everywhere, the air is fresh", 0, 0, 9, 11);
        Room room11 = new Room(11, "Treasure Room", "You've never seen so much wealth in one place", 0, 12, 10, 0);
        Room room12 = new Room(12, "Boos Room", "This place is unlike any you have encountered, the calmness that seems to be there snows you", 11,0, 0, 0);

        //Aggiunta Npc nelle stanze
        ZooController zooController = new ZooController();
        zooController.populateZoo();
        List<Animal> animals = new ArrayList<>();
        try{
            animals = zooController.getAnimalsList();
        } catch (AnimalNotFound e){
            System.err.println("No Npc found!!");
        }
        room2.addNpc(animals.get(0));
        room4.addNpc(animals.get(1));
        room5.addNpc(animals.get(2));
        room5.addNpc(animals.get(3));
        room6.addNpc(animals.get(4));
        room6.addNpc(animals.get(5));
        room8.addNpc(animals.get(6));
        room11.addNpc(animals.get(7));
        room12.addNpc(animals.get(8));

        //Aggiunta oggetti nelle stanze
        ItemController itemController = new ItemController();
        itemController.generateItems();
        List<Item> items = itemController.getItems();
        room3.addItem(items.get(0));
        room3.addItem(items.get(2));
        room6.addItem(items.get(1));
        room6.addItem(items.get(4));
        room7.addItem(items.get(8));
        room8.addItem(items.get(7));
        room9.addItem(items.get(9));
        room10.addItem(items.get(3));
        room11.addItem(items.get(5));
        room11.addItem(items.get(6));

        map1.put(1,room1);
        map1.put(2,room2);
        map1.put(3,room3);
        map1.put(4,room4);
        map1.put(5,room5);
        map1.put(6,room6);
        map1.put(7,room7);
        map1.put(8,room8);
        map1.put(9,room9);
        map1.put(10,room10);
        map1.put(11,room11);
        map1.put(12,room12);
        return map1;

    }

    public Map<Integer, Room> getMap() {
        return map;
    }

    public void printKey(){
        System.out.println(map.keySet());
    }
}

package game.controller;

import animal.controller.ZooController;
import animal.model.Animal;
import animal.exception.AnimalNotFound;
import game.model.Item;
import game.model.Room;
import game.util.DirectionEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MapController {

    private Room currentRoom;

    public MapController(){
        currentRoom = new Room("Basement", "a dark, cramped place");
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void generateMap(){
        Room room2 = new Room("Thermal Baths", "a warm place, there is a lot of fog and hot water gaiser");
        Room room3 = new Room("Cave", "a dark cave, you hear a lot of chilling noises");
        Room room4 = new Room("Mausoleum", "in front of a grave, but it’s too big to be a normal person");
        Room room5 = new Room("Temple", "an old temple, the stones are worn, there is moss everywhere, torches illuminate a flight of steps leading to a throne");
        Room room6 = new Room("Downpour", "you're soaked in dirty water");
        Room room7 = new Room("Mines", "you see hundreds of sparkles in the dark");
        Room room8 = new Room("Jungle", "you catch a glimpse of dense vegetation, it is pouring rain, and there is a herd of monkeys watching you");
        Room room9 = new Room("Desert", "the air is hot and the place seems hostile");
        Room room10 = new Room( "Mountain", "you are on the top of a very high mountain, there is snow everywhere, the air is fresh");
        Room room11 = new Room( "Treasure Room", "You've never seen so much wealth in one place");
        Room room12 = new Room( "Boos Room", "This place is unlike any you have encountered, the calmness that seems to be there snows you");

        //Aggiunta Npc nelle stanze
        ZooController zooController = new ZooController();
        zooController.populateZoo();
        Logger logger = Logger.getLogger(getClass().getName());
        List<Animal> animals = new ArrayList<>();
        try{
            animals = zooController.getAnimalsList();
        } catch (AnimalNotFound e){
            logger.log(Level.WARNING,"No Npc found!!");
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
        room3.addItem(new Item("Potion", "Heals 20 HP", 1));
        room3.addItem(new Item("Super Potion", "Heals 50 HP", 1));
        room6.addItem(new Item("Hyper Potion", "Heals 200 HP", 2));
        room6.addItem(new Item("Full Heal", "Heals all status conditions", 1));
        room7.addItem(new Item("Full Restore", "Heals all HP and status conditions", 2));
        room8.addItem(new Item("Sword", "+10 atk", 1));
        room9.addItem(new Item("Shield", "+10 def", 1));
        room10.addItem(new Item("Armor", "+50 def, -20 speed", 2));
        room11.addItem(new Item("Bow", "+10 sp.atk, +10speed", 1));
        room11.addItem(new Item("Gun", "+20 sp.atk, +20 sp.def", 2));

        //Collegamento delle stanze
        connectRooms(currentRoom, room3, DirectionEnum.WEST);
        connectRooms(currentRoom, room6, DirectionEnum.EAST);
        connectRooms(currentRoom, room2, DirectionEnum.SOUTH);
        connectRooms(room3, room4, DirectionEnum.NORTH);
        connectRooms(room3, room5, DirectionEnum.WEST);
        connectRooms(room6, room8, DirectionEnum.NORTH);
        connectRooms(room8, room9, DirectionEnum.NORTH);
        connectRooms(room9, room10, DirectionEnum.EAST);
        connectRooms(room10, room11, DirectionEnum.EAST);
        connectRooms(room11, room12, DirectionEnum.SOUTH);
    }

    public void connectRooms(Room roomA, Room roomB, DirectionEnum direction){
        switch (direction){
            case NORTH:
                roomA.addConnectedRoom(DirectionEnum.NORTH, roomB);
                roomB.addConnectedRoom(DirectionEnum.SOUTH, roomA);
                break;
            case SOUTH:
                roomA.addConnectedRoom(DirectionEnum.SOUTH, roomB);
                roomB.addConnectedRoom(DirectionEnum.NORTH, roomA);
                break;
            case EAST:
                roomA.addConnectedRoom(DirectionEnum.EAST, roomB);
                roomB.addConnectedRoom(DirectionEnum.WEST, roomA);
                break;
            case WEST:
                roomA.addConnectedRoom(DirectionEnum.WEST, roomB);
                roomB.addConnectedRoom(DirectionEnum.EAST, roomA);
                break;
        }
    }

    public String changeCurrentRoom(String direction){
        DirectionEnum currentDirection = DirectionEnum.getDirectionByString(direction);

        if (currentDirection == null)
            return ("Incorrect direction");

        else if(currentRoom.getConnectedRoomByDirection(currentDirection) != null){
            currentRoom = currentRoom.getConnectedRoomByDirection(currentDirection);
            return (getCurrentRoom().look());
        }
        else{
            return ("No room in this direction");
        }
    }

}

package com.example.Pawtropolis.game.service;

import com.example.Pawtropolis.animal.service.ZooManager;
import com.example.Pawtropolis.animal.exception.AnimalNotFound;
import com.example.Pawtropolis.animal.model.Animal;
import com.example.Pawtropolis.game.model.*;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

@Log
@Getter
@Service
public class MapManager {
    private final ZooManager zooManager;
    private Room currentRoom;

    private MapManager(ZooManager zooManager){
        currentRoom = new Room("Basement", "a dark, cramped place");
        this.zooManager = zooManager;
    }

    @PostConstruct
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
        zooManager.populateZoo();
        List<Animal> animals = new ArrayList<>();
        try{
            animals = zooManager.getAnimalsList();
        } catch (AnimalNotFound e){
            log.log(Level.WARNING,"No Npc found!!");
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
        currentRoom.addItem(new Item("Key", "A simple key", 1));
        currentRoom.addItem(new Item("Gun", "+20 sp.atk, +20 sp.def", 2));
        room4.addItem(new Item("Black key", "A strange key", 2));
        room9.addItem(new Item("Key", "A simple key", 1));
        room5.addItem(new Item("Key", "A simple key", 1));

        Door redDoor = new Door(false,"key");
        Door yellowDoor = new Door(true,"key");
        Door orangeDoor = new Door(true,"key");
        Door blueDoor = new Door(true,"key");
        Door greenDoor = new Door(true,"key");
        Door brownDoor = new Door(true,"key");
        Door pinkDoor = new Door(true,"key");
        Door greyDoor = new Door(false,"key");
        Door whiteDoor = new Door(true,"key");
        Door blackDoor = new Door(false,"Black key");



        //Collegamento delle stanze
        connectRooms(currentRoom, room3, Direction.WEST, redDoor);
        connectRooms(currentRoom, room6, Direction.EAST, yellowDoor);
        connectRooms(currentRoom, room2, Direction.SOUTH, orangeDoor);
        connectRooms(room3, room4, Direction.NORTH, blueDoor);
        connectRooms(room3, room5, Direction.WEST, greenDoor);
        connectRooms(room6, room8, Direction.NORTH, brownDoor);
        connectRooms(room8, room9, Direction.NORTH, pinkDoor);
        connectRooms(room9, room10, Direction.EAST, greyDoor);
        connectRooms(room10, room11, Direction.EAST, whiteDoor);
        connectRooms(room11, room12, Direction.SOUTH, blackDoor);
    }

    public void connectRooms(Room entryRoom, Room exitRoom, Direction direction, Door door){
        switch (direction) {
            case NORTH -> {
                entryRoom.addConnectedRoom(Direction.NORTH, exitRoom, door);
                exitRoom.addConnectedRoom(Direction.SOUTH, entryRoom, door);
            }
            case SOUTH -> {
                entryRoom.addConnectedRoom(Direction.SOUTH, exitRoom, door);
                exitRoom.addConnectedRoom(Direction.NORTH, entryRoom, door);
            }
            case EAST -> {
                entryRoom.addConnectedRoom(Direction.EAST, exitRoom, door);
                exitRoom.addConnectedRoom(Direction.WEST, entryRoom, door);
            }
            case WEST -> {
                entryRoom.addConnectedRoom(Direction.WEST, exitRoom, door);
                exitRoom.addConnectedRoom(Direction.EAST, entryRoom, door);
            }
        }
    }

    public String lookCurrentRoom() {
        return getCurrentRoom().look();
    }

    public void removeItemInRoom(Item item){
        getCurrentRoom().removeItem(item);
    }

    public void addItemInRoom(Item item) {
        getCurrentRoom().addItem(item);
    }

    public Item getChosenItemInRoom(String itemName) {
        return getCurrentRoom().getItemByString(itemName);
    }

    public String changeCurrentRoom(String direction, Player player){
        Direction currentDirection = Direction.getDirectionByString(direction);

        if (currentDirection == null)
            return ("Incorrect direction");

        else if(currentRoom.getConnectedRoomByDirection(currentDirection) != null){
            if(openDoor(Direction.getDirectionByString(direction), player)){
                currentRoom = currentRoom.getConnectedRoomByDirection(currentDirection);
                return (getCurrentRoom().look());
            }else {
                return null;
            }
        }
        else{
            return ("No room in this direction");
        }
    }

    public boolean openDoor(Direction direction, Player player) {
        Door door = currentRoom.getDoor(direction);
        Scanner scanner = new Scanner(System.in);
        if (!door.isOpen()) {
            System.out.println("The door is locked. Would you like to use an item to unlock it? Y/N");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                return unlockDoor(direction, player);
            } else if (answer.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("You must answer Y or N");
                return false;
            }
        } else {
            return true;
        }
    }

    public boolean unlockDoor(Direction direction, Player player) {
        Door door = currentRoom.getDoor(direction);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the name of the chosen item");
        String itemName = scanner.nextLine();
        if (player.isPresentInBag(itemName) && door.unlock(itemName)) {
            System.out.println("You unlocked the door!");
            Item removedItem = player.getItemInBagByString(itemName);
            player.removeItemFromBag(removedItem);
            return true;
        } else {
            System.out.println("You need " + door.getRequiredKey() + " to open the door");
            return false;
        }
    }
}

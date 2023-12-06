package game.domain;

import game.console.InputController;
import map.domain.Room;

public class Player {
    private final String name;
    private int healthPoints;
    private Bag myBag;

    public Player(String name) {
        this.name = name;
        healthPoints = 10;
        myBag = new Bag();
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Bag getMyBag() {
        return myBag;
    }

    public Room go(MapController mapController, Room currentRoom){
        System.out.println("Choose direction: n, s, e, w");
        System.out.print(">");
        String input = InputController.readString();
        switch (input){
            case "n":
                if(currentRoom.getN() != 0){
                    return mapController.getMap().get(currentRoom.getN());
                }
                else{
                    System.out.println("There's no room here ");
                    return null;
                }
            case "s":
                if(currentRoom.getS() != 0){
                    return mapController.getMap().get(currentRoom.getS());
                }
                else {
                    System.out.println("There's no room here ");
                    return null;
                }
            case "w":
                if(currentRoom.getW() != 0){
                    return mapController.getMap().get(currentRoom.getW());
                }
                else{
                    System.out.println("There's no room here ");
                    return null;
                }
            case "e":
                if(currentRoom.getE() != 0){
                    return mapController.getMap().get(currentRoom.getE());
                }
                else{
                    System.out.println("There's no room here ");
                    return null;
                }
            default:
                System.out.println("Invalid direction.");
                return null;
        }
    }

    public Item get(Room currentRoom){
        System.out.println("Choose item to take:\n" + currentRoom.getItemInRoom());
        System.out.print(">");
        String inputItemToTake = InputController.readString();
        Item chosenItemToTake = currentRoom.getItems()
                .stream()
                .filter(i -> i.getName().equals(inputItemToTake))
                .findFirst()
                .orElseGet(() -> null);
        if(chosenItemToTake != null){
            myBag.addItemInBag(chosenItemToTake);
            return chosenItemToTake;
        }
        else{
            System.out.println("No item " + inputItemToTake +" in this room.");
            return null;
        }
    }

    public Item drop(Room currentRoom){
        System.out.println("Choose item to drop:\n" + getMyBag().getItemsInBag());
        System.out.print(">");
        String inputItemToDrop = InputController.readString();
        Item chosenItemToDrop = getMyBag()
                .getItems()
                .stream()
                .filter(i -> i.getName().equals(inputItemToDrop))
                .findFirst()
                .orElseGet(() -> null);
        if(chosenItemToDrop != null){
            getMyBag().removeItemFromBag(chosenItemToDrop);
            return chosenItemToDrop;
        }
        else{
            System.out.println("No item " + inputItemToDrop +" in the bag.");
            return null;
        }
    }
}

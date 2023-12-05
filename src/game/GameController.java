package game;

import game.console.InputController;
import game.domain.Item;
import game.domain.Player;
import map.MapController;
import map.domain.Room;

public class GameController {
    private final Room entry;
    private final Player player;

    public GameController(Room entry, Player player) {
        this.entry = entry;
        this.player = player;
    }

    public void runGame() {
        MapController mapController = new MapController();
        Room currentRoom = entry;
        boolean gameEnded = false;

        while(!gameEnded) {
            String input;
            System.out.println("Where are you going to go?");
            System.out.print(">");
            input = InputController.readString();
            switch(input){
                case "look":
                    System.out.println(currentRoom.getRoomDescription());
                    break;
                case "bag":
                    System.out.println(player.getMyBag().getItemsInBag());
                    break;
                case "go":
                    System.out.println("Choose direction: n, s, e, w");
                    System.out.print(">");
                    input = InputController.readString();
                    switch (input){
                        case "n":
                            if(currentRoom.getN() != 0){
                                currentRoom = mapController.getMap().get(currentRoom.getN());
                            }
                            else{
                                System.out.println("There's no room here ");
                            }
                            break;
                        case "s":
                            if(currentRoom.getS() != 0){
                                currentRoom = mapController.getMap().get(currentRoom.getS());
                            }
                            else{
                                System.out.println("There's no room here ");
                            }
                            break;
                        case "w":
                            if(currentRoom.getW() != 0){
                                currentRoom = mapController.getMap().get(currentRoom.getW());
                            }
                            else{
                                System.out.println("There's no room here ");
                            }
                            break;
                        case "e":
                            if(currentRoom.getE() != 0){
                                currentRoom = mapController.getMap().get(currentRoom.getE());
                            }
                            else{
                                System.out.println("There's no room here ");
                            }
                            break;
                    }
                    break;
                case "get":
                    System.out.println("Choose item to take:\n" + currentRoom.getItemInRoom());
                    System.out.print(">");
                    String inputItemToTake = InputController.readString();
                    Item chosenItemToTake = currentRoom.getItems()
                            .stream()
                            .filter(i -> i.getName().equals(inputItemToTake))
                            .findFirst()
                            .orElseGet(() -> null);
                    if(chosenItemToTake != null){
                        player.getMyBag().addItemInBag(chosenItemToTake);
                        currentRoom.removeItem(chosenItemToTake);
                    }
                    break;
                case "drop":
                    System.out.println("Choose item to drop:\n" + player.getMyBag().getItemsInBag());
                    System.out.print(">");
                    String inputItemToDrop = InputController.readString();
                    Item chosenItemToDrop = player.getMyBag()
                            .getItems()
                            .stream()
                            .filter(i -> i.getName().equals(inputItemToDrop))
                            .findFirst()
                            .orElseGet(() -> null);
                    if(chosenItemToDrop != null){
                        currentRoom.addItem(chosenItemToDrop);
                        player.getMyBag().removeItemFromBag(chosenItemToDrop);
                    }
                    break;
            }
            if (input.equals("exit")) {
                gameEnded = true;
            }
        }
    }
}

package game;

import game.console.InputController;
import game.model.Player;
import map.MapController;
import map.model.Room;

public class GameController {
    private final Room entry;
    private final Player player;
    private final MapController mapController;

    public GameController(Room entry, Player player) {
        this.entry = entry;
        this.player = player;
        mapController = new MapController();
        //Ciao
    }

    public void runGame() {
        Room currentRoom = entry;
        System.out.println(mapController.getMap().get(currentRoom.getEast()));
        boolean gameEnded = false;

        while(!gameEnded) {
            String input;
            System.out.println("What do you want to do? (look, go, bag, get, drop)");
            System.out.print(">");
            input = InputController.readString();
            switch(input){
                case "look":
                    System.out.println(lookInRoom(currentRoom));
                    break;
                case "bag":
                    System.out.println(lookInBag());
                    break;
                case "go":
                    currentRoom = player.go(mapController, currentRoom);
                    break;
                case "get":
                    currentRoom.removeItem(player.get(currentRoom));
                    break;
                case "drop":
                    currentRoom.addItem(player.drop(currentRoom));
                    break;
                default:
                    System.out.println("Invalid command.");
            }
            if (input.equals("exit")) {
                gameEnded = true;
            }
        }
    }

    private String lookInRoom(Room room){
        return room.getRoomDescription();
    }

    private String lookInBag(){
        return player.getMyBag().getItemsInBag();
    }
}

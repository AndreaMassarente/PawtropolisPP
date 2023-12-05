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
        mapController.printKey();
        Room currentRoom = entry;
        boolean gameEnded = false;

        while(!gameEnded) {
            String input;
            System.out.println("Where are you going to go?");
            System.out.print(">");
            input = InputController.readString();
            switch(input){
                case "look":
                    System.out.println("You are in Room " + currentRoom.getId() +  "\n" + currentRoom.getDescription() + "\nItems: " + currentRoom.getItems()
                            +"\nNCP: " + currentRoom.getNpc());
                    break;
                case "bag":
                    System.out.println(player.getMyBag().getItems());
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
                    System.out.println("Choose item to take:\n" + currentRoom.getItems());
                    System.out.print(">");
                    Item chosenItem = currentRoom.getItems()
                            .stream()
                            .filter(i -> i.getName().equals(InputController.readString()))
                            .findFirst()
                            .orElseGet(() -> null);
                    if(chosenItem != null){
                        //Metodo in Room per rimozione item
                    }
                    break;
                case "drop":

                    break;

            }
            /*
             * Inserire qui la gestione degli altri comandi
             */


            if (input.equals("exit")) {
                gameEnded = true;
            }
        }
    }
}

package game.util.command;

public class Go extends Command{
    private final CommandController commandController;
    private final String direction;
    public Go(CommandController commandController, String direction){
        this.commandController = commandController;
        this.direction = direction;
    }


    public String execute(){
        return commandController.getMapController().changeCurrentRoom(direction);
    }

}

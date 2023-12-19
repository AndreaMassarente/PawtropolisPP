package game.util.command;


public class Look {
    private final CommandController commandController;
    public Look(CommandController commandController){
        this.commandController = commandController;
    }

    public String execute(){
        return commandController.getMapController().getCurrentRoom().look();
    }
}

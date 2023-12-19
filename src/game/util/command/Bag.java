package game.util.command;

public class Bag {
    private final CommandController commandController;
    public Bag(CommandController commandController){
        this.commandController = commandController;
    }

    public String execute(){
        return commandController.getPlayer().getBag().getItemsToString();
    }
}

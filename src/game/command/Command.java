package game.command;

import game.controller.CommandFactory;

public abstract class Command <T>{
    private final CommandFactory commandFactory;

    protected Command(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public CommandFactory getCommandRunner() {
        return commandFactory;
    }

    public abstract T execute();
}

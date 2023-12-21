package game.command;

import game.controller.CommandRunner;

public abstract class Command <T>{
    //TODO: Valutare di rendere command un'interfaccia
    private final CommandRunner commandRunner;

    protected Command(CommandRunner commandRunner) {
        this.commandRunner = commandRunner;
    }

    public CommandRunner getCommandRunner() {
        return commandRunner;
    }

    public abstract T execute();
}

package game.util.command;

import game.controller.CommandRunner;

public abstract class Command <T>{
    private final CommandRunner commandRunner;

    protected Command(CommandRunner commandRunner) {
        this.commandRunner = commandRunner;
    }

    public CommandRunner getCommandRunner() {
        return commandRunner;
    }

    public abstract T execute();
}

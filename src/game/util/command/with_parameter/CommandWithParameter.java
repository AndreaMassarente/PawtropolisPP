package game.util.command.with_parameter;

import game.controller.CommandRunner;
import game.util.command.Command;

public abstract class CommandWithParameter <T> extends Command <T> {
    private final String parameter;

    protected CommandWithParameter(CommandRunner commandRunner, String parameter) {
        super(commandRunner);
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}

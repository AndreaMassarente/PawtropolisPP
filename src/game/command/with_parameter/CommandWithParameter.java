package game.command.with_parameter;

import game.command.Command;
import game.controller.CommandRunner;

public abstract class CommandWithParameter <T> extends Command<T> {
    private final String parameter;

    protected CommandWithParameter(CommandRunner commandRunner, String parameter) {
        super(commandRunner);
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}

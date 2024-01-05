package game.command.with_parameter;

import game.command.Command;
import game.controller.CommandFactory;

public abstract class CommandWithParameter <T> extends Command<T> {
    private final String parameter;

    protected CommandWithParameter(CommandFactory commandFactory, String parameter) {
        super(commandFactory);
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}

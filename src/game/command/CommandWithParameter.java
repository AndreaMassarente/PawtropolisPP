package game.command;

import game.controller.CommandFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandWithParameter <T> extends Command<T> {
    private final List<String> parameter;

    protected CommandWithParameter(CommandFactory commandFactory){
        super(commandFactory);
        parameter = new ArrayList<>();
    }
    protected CommandWithParameter(CommandFactory commandFactory, ArrayList<String> parameter) {
        super(commandFactory);
        this.parameter = parameter;
    }

    public List<String> getParameter() {
        return parameter;
    }
}

package game.command;

import game.controller.CommandFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class ParametrizedCommand<T> extends Command<T> {
    private List<String> parameter;

    protected ParametrizedCommand(CommandFactory commandFactory){
        super(commandFactory);
        parameter = new ArrayList<>();
    }
    protected ParametrizedCommand(CommandFactory commandFactory, List<String> parameter) {
        super(commandFactory);
        this.parameter = parameter;
    }

    public List<String> getParameter() {
        return parameter;
    }

    public void setParameter(List<String> parameter) {
        this.parameter = parameter;
    }
}

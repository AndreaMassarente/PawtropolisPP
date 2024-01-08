package game.command;

import game.controller.GameController;

import java.util.ArrayList;
import java.util.List;

public abstract class ParametrizedCommand<T> extends Command<T> {
    private List<String> parameter;

    protected ParametrizedCommand(GameController gameController){
        super(gameController);
        parameter = new ArrayList<>();
    }
    protected ParametrizedCommand(GameController gameController, List<String> parameter) {
        super(gameController);
        this.parameter = parameter;
    }

    public List<String> getParameter() {
        return parameter;
    } //Cambiare il tipo di ritorno?

    public void setParameter(List<String> parameter) {
        this.parameter = parameter;
    }
}

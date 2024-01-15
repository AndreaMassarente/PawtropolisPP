package com.example.Pawtropolis.game.command;


import com.example.Pawtropolis.game.controller.GameController;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
}

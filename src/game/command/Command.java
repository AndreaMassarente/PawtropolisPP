package game.command;

import game.controller.CommandFactory;
import game.controller.GameController;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Command <T>{
    //TODO: Valutare di rendere command un'interfaccia
    private final GameController gameController;

    public abstract T execute();
}

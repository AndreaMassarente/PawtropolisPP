package game.command;

import game.controller.GameController;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Command <T>{
    private final GameController gameController;

    public abstract T execute();
}

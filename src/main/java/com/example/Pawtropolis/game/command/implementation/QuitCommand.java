package com.example.Pawtropolis.game.command.implementation;


import com.example.Pawtropolis.game.command.Command;
import com.example.Pawtropolis.game.controller.GameController;
import org.springframework.stereotype.Component;

@Component("quitCommand")
public class QuitCommand extends Command<String> {
    public QuitCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public String execute() {
        return "quit";
    }
}

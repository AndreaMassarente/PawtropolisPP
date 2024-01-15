package com.example.SpringTest.game.command.implementation;


import com.example.SpringTest.game.command.Command;
import com.example.SpringTest.game.controller.GameController;

//@Component
public class QuitCommand extends Command<String> {
    public QuitCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public String execute() {
        return "quit";
    }
}

package game.model.npc.model.tailed.implementation;

import game.model.npc.model.tailed.AnimalWithTail;

import java.time.LocalDate;

public class Lion extends AnimalWithTail {
    public Lion(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, arrivalDate, weight, height, tailLength);
    }
}

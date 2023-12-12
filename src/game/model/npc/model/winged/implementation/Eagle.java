package game.model.npc.model.winged.implementation;

import game.model.npc.model.winged.AnimalWithWings;

import java.time.LocalDate;

public class Eagle extends AnimalWithWings {
    public Eagle(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double wingspan) {
        super(name, favouriteFood, age, arrivalDate, weight, height, wingspan);
    }
}

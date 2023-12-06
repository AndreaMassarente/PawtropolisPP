package animals.model.tailed.implementation;

import animals.model.tailed.AnimalWithTail;

import java.time.LocalDate;

public class Tiger extends AnimalWithTail {
    public Tiger(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, arrivalDate, weight, height, tailLength);
    }
}
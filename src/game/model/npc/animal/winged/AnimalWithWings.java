package game.model.npc.animal.winged;

import game.model.npc.animal.Animal;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AnimalWithWings extends Animal {
    private double wingspan;

    protected AnimalWithWings(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double wingspan) {
        super(name, favouriteFood, age, arrivalDate, weight, height);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public String toString() {
        return super.toString() + "zoo.animal.AnimalWithWings{" +
                "wingspan=" + wingspan +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AnimalWithWings that = (AnimalWithWings) o;
        return Double.compare(wingspan, that.wingspan) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wingspan);
    }
}

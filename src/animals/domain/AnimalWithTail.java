package animals.domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AnimalWithTail extends Animal {
    private double tailLength;

    protected AnimalWithTail(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, arrivalDate, weight, height);
        this.tailLength = tailLength;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    @Override
    public String toString() {
        return super.toString() + "zoo.animal.AnimalWithTail{" +
                "tailLength=" + tailLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AnimalWithTail that = (AnimalWithTail) o;
        return Double.compare(tailLength, that.tailLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tailLength);
    }
}

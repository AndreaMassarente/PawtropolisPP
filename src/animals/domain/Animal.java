package animals.domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Animal {
    private String name;
    private String favouriteFood;
    private int age;
    private LocalDate arrivalDate;
    private double weight;
    private double height;

    protected Animal(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height) {
        this.name = name;
        this.favouriteFood = favouriteFood;
        this.age = age;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "zoo.animal.Animal{" +
                "name='" + name + '\'' +
                ", favouriteFood='" + favouriteFood + '\'' +
                ", age=" + age +
                ", arrivalDate=" + arrivalDate +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Double.compare(weight, animal.weight) == 0 && Double.compare(height, animal.height) == 0 && Objects.equals(name, animal.name) && Objects.equals(favouriteFood, animal.favouriteFood) && Objects.equals(arrivalDate, animal.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, favouriteFood, age, arrivalDate, weight, height);
    }
}

package animals.exception;

import animals.model.Animal;

public class SpeciesNotFound extends Throwable{
    private final Class<? extends Animal> animal;

    public SpeciesNotFound(Class<? extends Animal> animal){
        this.animal = animal;
    }

    public String getSpeciesNotFound() {
        return animal.getName();
    }
}

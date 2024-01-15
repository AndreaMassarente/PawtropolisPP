package com.example.SpringTest.animal.exception;


import com.example.SpringTest.animal.model.Animal;

public class SpeciesNotFound extends Exception{
    private final Class<? extends Animal> animal;

    public SpeciesNotFound(Class<? extends Animal> animal){
        this.animal = animal;
    }

    public String getSpeciesNotFound() {
        return animal.getName();
    }
}

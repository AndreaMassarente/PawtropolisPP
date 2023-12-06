package animals;



import animals.model.*;
import animals.exception.AnimalNotFound;
import animals.exception.SpeciesNotFound;
import animals.exception.SpecificTraitNotFound;
import animals.model.tailed.AnimalWithTail;
import animals.model.tailed.implementation.Armadillo;
import animals.model.tailed.implementation.Lion;
import animals.model.tailed.implementation.Tiger;
import animals.model.winged.AnimalWithWings;
import animals.model.winged.implementation.Eagle;

import java.time.LocalDate;
import java.util.*;

public class ZooController {
    private final Map<Class<? extends Animal>, List<Animal>> allAnimal;

    public ZooController() {
        this.allAnimal = new HashMap<>();
    }

    //Metodi per popolare lo zoo
    public void populateZoo(){
        addAnimal(new Lion("Rey", "Meat", 5, LocalDate.of(2006,1,15) , 150, 120, 0.6));
        addAnimal(new Lion("Lucas", "Meat",4, LocalDate.of(2004, 2, 20), 120, 100, 1));
        addAnimal(new Tiger("Rik", "Fruit", 2, LocalDate.of(2001,5,12),1,30, 1.3));
        addAnimal(new Tiger("Sia","Meat", 10, LocalDate.of(2011,8,8),10,20,0.6));
        addAnimal(new Eagle("Tommy","Rodent",5, LocalDate.of(2021, 2, 20),30,400,4));
        addAnimal(new Eagle("Debby", "Insect", 6, LocalDate.of(2021,5,2),5,30,1));
        addAnimal(new Armadillo("Miki","Ants",3,LocalDate.of(2021,4,16),6,4,0.5));
        addAnimal(new Armadillo("Simon","Apple",4,LocalDate.of(2019,3,15),7,7,0.7));
        addAnimal(new Lion("Joffry", "Human",  6, LocalDate.of(2021,11,21), 30,30, 2 ));
    }
    public <T extends Animal> void addAnimal(T animal){
        allAnimal.computeIfAbsent(animal.getClass(), e -> new ArrayList<>()).add(animal);
        //Crea la lista associata alla specie animale in questione, nel caso in cui non sia già presente.
        //Se è già presente vi inserisce l'elemento
    }


    //Ritorno di tutti gli animali dello zoo
    public List<Animal> getAnimalsList() throws AnimalNotFound {
        return allAnimal.values().
                stream()
                .flatMap(Collection::stream)
                .toList();
    }


    //Metodi per ricerca in base all'altezza e il peso, per specie
    private <T extends Animal> List<T> findAllAnimalsOfASpecies(Class<T> animal){
        return (List<T>) allAnimal.getOrDefault(animal, Collections.emptyList());
    }
    public <T extends Animal> T findHighestAnimalBySpecies(Class<T> animal) throws SpeciesNotFound {
        return findAllAnimalsOfASpecies(animal).stream()
                .max(Comparator.comparingDouble(Animal::getHeight))
                .orElseThrow(() -> new SpeciesNotFound(animal));
    }
    public <T extends Animal> T findLowestAnimalBySpecies(Class<T> animal) throws SpeciesNotFound {
        return findAllAnimalsOfASpecies(animal).stream()
                .min(Comparator.comparingDouble(Animal::getHeight))
                .orElseThrow(() -> new SpeciesNotFound(animal));
    }
    public <T extends Animal> T findHeaviestAnimalBySpecies(Class<T> animal) throws SpeciesNotFound{
        return findAllAnimalsOfASpecies(animal).stream()
                .max(Comparator.comparingDouble(Animal::getWeight))
                .orElseThrow(() -> new SpeciesNotFound(animal));
    }
    public <T extends Animal> T findLightestAnimalBySpecies(Class<T> animal) throws SpeciesNotFound {
        return findAllAnimalsOfASpecies(animal).stream()
                .min(Comparator.comparingDouble(Animal::getWeight))
                .orElseThrow(() -> new SpeciesNotFound(animal));
    }


    //Metodi per ricerca in base a tratti specifici
    //TODO Cambia il ritorno del metodo (e anche il parametro passato) con la generics T
    private <T extends Animal> List<T> findAnimalsByTrait(Class<T> animal) throws SpecificTraitNotFound {
        List<? extends  Animal> animals =  allAnimal.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(animal::isInstance)
                .toList();

        if(animals.isEmpty())
            throw new SpecificTraitNotFound();

        return (List<T>) animals;
    }
    public AnimalWithTail findAnimalWithLongestTail() throws SpecificTraitNotFound {
        List<? extends Animal> animalsWithTail = findAnimalsByTrait(AnimalWithTail.class);
        return animalsWithTail.stream()
                .map(AnimalWithTail.class::cast)
                .max(Comparator.comparingDouble(AnimalWithTail::getTailLength))
                .orElse(null);
    }
    public AnimalWithWings findAnimalWithGreatestWingspan() throws SpecificTraitNotFound{
        List<? extends Animal> animalsWithWings = findAnimalsByTrait(AnimalWithWings.class);
        return animalsWithWings.stream()
                .map(AnimalWithWings.class::cast)
                .max(Comparator.comparingDouble(AnimalWithWings::getWingspan))
                .orElse(null);
    }


    //Metodi per rimozione animale e (nel caso) specie
    private void removeEmptySpecies(Animal animal){
        if(allAnimal.get(animal.getClass()).isEmpty())
            allAnimal.remove(animal.getClass());
    } //Controllo se la specie è vuota in seguito a una rimozione, in caso affermativo la rimuovo
    private Animal findAnimalByName(String animalName){
        return allAnimal.values().stream()
                .flatMap(Collection::stream)
                .filter(animal -> animal.getName().equals(animalName))
                .findFirst()
                .orElse(null);
    }
    public void removesAnAnimal(String animalName) throws AnimalNotFound {
        Animal animal = findAnimalByName(animalName);
        if(animal == null)
            throw new AnimalNotFound();
        allAnimal.computeIfPresent(animal.getClass(),(k, v) -> {v.remove(animal); return v;});
        removeEmptySpecies(animal);
    }


    //Metodo che ritorna la lista delle speci
    public List<Class<? extends Animal>> getListOfSpecies(){
        return allAnimal.keySet().stream()
                .toList();
    }
}

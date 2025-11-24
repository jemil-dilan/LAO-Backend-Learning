package POO_Collection_Optional.Exercise7.zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Enclosure{

    private String specie;
    private List<Animal> animals;

    public Enclosure(String specie) {

        this.specie = specie;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {

        if (Objects.equals(specie, animal.getSpecies()))
            animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void feedAnimals(){
        animals.forEach(Animal::eat);
    }
}

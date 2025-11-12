package POO_Collection_Optional.Exercise7.zoo;

import java.util.ArrayList;
import java.util.List;

public class Enclosure{

    private List<Animal> animals;

    public Enclosure(String nom) {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void feedAnimals(){
        animals.forEach(Animal::eat);
    }
}

package POO_Collection_Optional.Exercise7.zoo;

import java.util.List;

public class Panda extends Animal{

    public Panda(String name, String species, List<SpecificNeed> specificNeeds) {
        super(name, species, specificNeeds);
    }

    @Override
    public void eat() {
        System.out.println("I eat " + SpecificNeed.HERBIVORE_FOOD);
    }
}

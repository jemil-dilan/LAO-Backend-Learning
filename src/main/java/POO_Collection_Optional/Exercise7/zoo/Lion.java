package POO_Collection_Optional.Exercise7.zoo;

import java.util.List;

public class Lion extends Animal{

    public Lion(String name, String species, List<SpecificNeed> specificNeeds) {
        super(name, species, specificNeeds);
    }

    @Override
    public void eat() {
        System.out.println("I eat " + SpecificNeed.CARNIVORES_FOOD);
    }
}

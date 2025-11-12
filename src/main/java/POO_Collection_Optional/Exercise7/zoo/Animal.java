package POO_Collection_Optional.Exercise7.zoo;

import java.util.List;

public abstract class Animal {

    protected String name;
    protected String species;
    protected List<SpecificNeed> specificNeeds;

    public Animal(String name, String species, List<SpecificNeed> specificNeeds) {
        this.name = name;
        this.species = species;
        this.specificNeeds = specificNeeds;
    }

    public void setSpecificNeeds(List<SpecificNeed> specificNeeds) {
        this.specificNeeds = specificNeeds;
    }

    public List<SpecificNeed> getSpecificNeeds() {
        return specificNeeds;
    }

    public abstract void eat();
}

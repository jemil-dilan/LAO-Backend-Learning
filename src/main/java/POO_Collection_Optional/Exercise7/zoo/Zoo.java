package POO_Collection_Optional.Exercise7.zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Zoo {

    private List<Enclosure> enclosures;

    public Zoo() {
        this.enclosures = new ArrayList<>();
    }

    public void addEnclosure(Enclosure enclosure) {
        this.enclosures.add(enclosure);
    }

    public List<Animal> getAnimalsByNeed(SpecificNeed specificNeed) {
        return enclosures.stream()
                .flatMap(e -> e.getAnimals().stream())
                .filter(a -> a.getSpecificNeeds().contains(specificNeed))
                .collect(Collectors.toList());
    }

    public void setAnimalsOfAnEnclosureSpecificsNeeds(Enclosure enclosure, List<SpecificNeed> specificNeeds){

        enclosures.stream().filter(enclosure1 -> Objects.equals(enclosure1, enclosure))
                .findFirst()
                .ifPresent(enclosure1 -> enclosure1.getAnimals().forEach(animal -> animal.setSpecificNeeds(specificNeeds)));
    }
}

package POO_Collection_Optional.Exercise7.zoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    static void main(String[] args) {

        Enclosure enclosure1 = new Enclosure("Lion");
        Enclosure enclosure2 = new Enclosure("Dolphin");
        Enclosure enclosure3 = new Enclosure("Panda");

        enclosure1.addAnimal(new Lion("Simba", "Lion", Arrays.stream(new SpecificNeed[]{SpecificNeed.CARNIVORES_FOOD, SpecificNeed.LARGE_SPACE}).toList()));
        enclosure1.addAnimal(new Lion("Mufaza", "Lion", Arrays.stream(new SpecificNeed[]{SpecificNeed.CARNIVORES_FOOD, SpecificNeed.HOT_TEMPERATURE}).toList()));
        enclosure2.addAnimal(new Dolphin("Oum", "Dolphin", Arrays.stream(new SpecificNeed[]{SpecificNeed.FISH, SpecificNeed.WATER, SpecificNeed.COLD_TEMPERATURE}).toList()));
        enclosure3.addAnimal(new Panda("Pô", "Panda", Arrays.stream(new SpecificNeed[]{SpecificNeed.HERBIVORE_FOOD, SpecificNeed.COLD_TEMPERATURE}).toList()));

        List<Enclosure> enclosures = new ArrayList<Enclosure>();
        enclosures.add(enclosure1);
        enclosures.add(enclosure2);

        Zoo theWazePark = new Zoo(enclosures);
        theWazePark.addEnclosure(enclosure3);

        System.out.println("\nAnimals with specific need " + SpecificNeed.COLD_TEMPERATURE);
        System.out.println(theWazePark.getAnimalsByNeed(SpecificNeed.COLD_TEMPERATURE));

        System.out.println("\nFeed all animals");
        theWazePark.feedAllAnimals();

        theWazePark.setAnimalsOfAnEnclosureSpecificsNeeds(enclosure1, Arrays.stream(new SpecificNeed[]{SpecificNeed.COLD_TEMPERATURE}).toList());
        System.out.println("\nAnimals with specific need " + SpecificNeed.COLD_TEMPERATURE);
        System.out.println(theWazePark.getAnimalsByNeed(SpecificNeed.COLD_TEMPERATURE));
    }
}

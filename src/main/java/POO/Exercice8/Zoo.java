import java.util.ArrayList;
import java.util.List;

public class Zoo {

    List<Animal> allTheAnimals = new ArrayList<Animal>();
    
    public void feedAllTheAnimals(){

        for (Animal animal : allTheAnimals) {
            
            animal.eat();
        }
    }

    public void nightHours(){

        for (Animal animal : allTheAnimals) {
            
            animal.sleep();
        }
    }
}